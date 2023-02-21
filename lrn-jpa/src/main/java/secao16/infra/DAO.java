package secao16.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

import static javax.persistence.Persistence.*;

public class DAO<E> {
    private EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;
    private Class<E> classe;

    static {
        try {
            entityManagerFactory = createEntityManagerFactory("exercicios_jpa");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DAO() {
        this(null);
    }

    public DAO(Class<E> classe) {
        this.classe = classe;
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void fechar() {
        entityManager.close();
    }

    public DAO<E> abrirT() {
        entityManager.getTransaction().begin();
        return this;
    }

    public DAO<E> fecharT() {
        entityManager.getTransaction().commit();
        return this;
    }

    public DAO<E> incluir(E entidade) {
        entityManager.persist(entidade);
        return this;
    }

    public DAO<E> incluirAtomico(E entidade) {
        return this.abrirT().incluir(entidade).fecharT();
    }

    public E obterporID(Object id) {
        return entityManager.find(this.classe, id);
    }

    public List<E> obterTodos() {
        return this.obterTodos(10, 0);
    }
    public List<E> obterTodos(int qtde, int deslocamento) {
        if(classe ==null) {
            throw new UnsupportedOperationException("Classe Nula");
        }

        String jpql = "select e from "+classe.getName()+" e";
        TypedQuery<E> query = entityManager.createQuery(jpql, classe);

        query.setMaxResults(qtde);
        query.setFirstResult(deslocamento);

        return query.getResultList();
    }

    public List<E> consultar(String nomeConsulta, Object... params) {
        TypedQuery<E> query = entityManager.createNamedQuery(nomeConsulta, classe);

        for (int i = 0; i < params.length; i += 2) {
            query.setParameter(params[i].toString(), params[i + 1]);
        }

        return query.getResultList();
    }

    public E consultarUm(String nomeConsulta, Object... params) {
        List<E> lista = consultar(nomeConsulta, params);
        return lista.isEmpty() ? null : lista.get(0);
    }
}
