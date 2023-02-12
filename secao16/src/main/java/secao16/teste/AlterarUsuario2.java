package secao16.teste;

import secao16.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarUsuario2 {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("exercicios_jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Usuario usuario = entityManager.find(Usuario.class, 2L);
		System.out.println(usuario.getId()+" >>> "+usuario.getEmail());
		
		usuario.setNome("Jane Jackson");
		usuario.setEmail("jane_dooe@email.com");
		
		//entityManager.merge(usuario);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
