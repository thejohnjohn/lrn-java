package secao16.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import secao16.Usuario;

public class NovoUsuario {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("exercicios_jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Usuario novoUsuario = new Usuario("John", "doe@email.com");

		System.out.println(novoUsuario.getId()+"|"+novoUsuario.getEmail());
		
		entityManager.getTransaction().begin();
		entityManager.persist(novoUsuario);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
