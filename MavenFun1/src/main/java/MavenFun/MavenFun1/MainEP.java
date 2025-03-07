package MavenFun.MavenFun1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MainEP {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersist1");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	public static void main(String[] args) {
		// Create and persist data
		createPersonWithPassport("John Bana", "PN01564");

		// Read the data
		Person1 person = readPerson(11);
		System.out.println("Person: " + person.getName() + ", Passport: " + person.getPassport().getPassportNumber());

		// Update the data
		updatePerson(11, "Ssekabira Robert");

		// Delete the data
		deletePerson(11);

		// Close EntityManager
		entityManager.close();
		entityManagerFactory.close();
	}

	// Create a Person and Passport
	public static void createPersonWithPassport(String personName, String passportNumber) {
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		// Create a new Person
		Person1 person = new Person1();
		person.setName(personName);

		// Create a new Passport and associate it with the Person
		Passport1 passport = new Passport1();
		passport.setPassportNumber(passportNumber);
		passport.setPerson(person);

		// Set the passport in the person entity as well
		person.setPassport(passport);

		// Persist both entities (due to CascadeType.ALL)
		entityManager.persist(person);

		transaction.commit();

	}

	// Read a Person by ID
	public static Person1 readPerson(int personId) {
		return entityManager.find(Person1.class, personId);
	}

	// Update a Person's name
	public static void updatePerson(int personId, String newName) {
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		Person1 person = entityManager.find(Person1.class, personId);
		if (person != null) {
			person.setName(newName);
			entityManager.merge(person);
		}

		transaction.commit();

	}

	// Delete a Person and associated Passport
	public static void deletePerson(int personId) {
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		Person1 person = entityManager.find(Person1.class, personId);
		if (person != null) {
			// Remove the person (and associated passport due to CascadeType.ALL)
			entityManager.remove(person);
		}

		transaction.commit();

	}

}
