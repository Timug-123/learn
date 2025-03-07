package MavenFun.MavenFun1;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class Person1 {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String name;

	    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	    private Passport1 passport;

	    // Getters and Setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Passport1 getPassport() {
	        return passport;
	    }

	    public void setPassport(Passport1 passport) {
	        this.passport = passport;
	    }
	
	}


