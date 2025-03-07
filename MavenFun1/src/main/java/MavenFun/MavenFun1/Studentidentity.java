package MavenFun.MavenFun1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Studentidentity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int identity_ID;
	@OneToOne(mappedBy = "studentidentity")
	private Studente Studente;
	private String identity_owner;
	private String School_Name;
	
	public Studentidentity(String identity_owner, String School_Name) {
		this.identity_owner = identity_owner;
		this.School_Name = School_Name;
	}

	public Studentidentity() {
		// TODO Auto-generated constructor stub
	}

	public Studente getStudente() {
		return Studente;
	}

	public void setStudente(Studente studente) {
		Studente = studente;
	}

	public String getIdentity_owner() {
		return identity_owner;
	}

	public void setIdentity_owner(String identity_owner) {
		this.identity_owner = identity_owner;
	}

	public String getSchool_Name() {
		return School_Name;
	}

	public void setSchool_Name(String school_Name) {
		School_Name = school_Name;
	}

	public void setIdentity_owner() {

	}

}
