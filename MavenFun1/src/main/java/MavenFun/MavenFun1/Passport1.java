package MavenFun.MavenFun1;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class Passport1 {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String passportNumber;

	    @OneToOne
	    @JoinColumn(name = "person_id")
	    private Person1 person;

	    // Getters and Setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getPassportNumber() {
	        return passportNumber;
	    }

	    public void setPassportNumber(String passportNumber) {
	        this.passportNumber = passportNumber;
	    }

	    public Person1 getPerson() {
	        return person;
	    }

	    public void setPerson(Person1 person) {
	        this.person = person;
	    }
	}


