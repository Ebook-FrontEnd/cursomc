package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.plaf.synth.SynthSeparatorUI;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		/**
		 * Exemplo de como instaciar objetos
		 * 
		 * Pessoa p1 = new Pessoa(null, "Breno Calado Maia", "breno@gmail.com"); 
		 * Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com"); 
		 * Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		 */

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		/**
		 * Exemplo de como persistir os objetos instaciados no banco
		 *
		 * entityManager.getTransaction().begin(); 
		 * entityManager.persist(p1);
		 * entityManager.persist(p2); 
		 * entityManager.persist(p3);
		 * entityManager.getTransaction().commit();
		 */

		
		/**
		 * Exemplo de como pesquisar um objeto no banco. 
		 */
		Pessoa getPessoa = entityManager.find(Pessoa.class, 2);
		
		entityManager.getTransaction().begin();
		entityManager.remove(getPessoa);
		entityManager.getTransaction().commit();
		
		System.out.println(getPessoa);
		System.out.println("pronto");
		
		entityManager.close();
		entityManagerFactory.close();

	}

}
