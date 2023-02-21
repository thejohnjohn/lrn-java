package secao16.teste;

import secao16.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RemoverUsuario {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("exercicios_jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Usuario usuario = entityManager.find(Usuario.class, 2L);

        if(usuario != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(usuario);
            entityManager.getTransaction().commit();
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
