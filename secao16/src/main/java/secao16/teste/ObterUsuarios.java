package secao16.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import secao16.Usuario;

public class ObterUsuarios {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("exercicios_jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String jpql = "select u from Usuario u";
		
		TypedQuery<Usuario> typedQuery = entityManager.createQuery(jpql, Usuario.class);
		typedQuery.setMaxResults(3);
		
		List<Usuario> usuarios = typedQuery.getResultList();
		
		for(Usuario usuario: usuarios) {
			System.out.println(usuario.getNome());
		}
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
