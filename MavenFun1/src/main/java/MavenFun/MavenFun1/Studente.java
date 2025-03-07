package MavenFun.MavenFun1;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
@Entity
public class Studente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Stud_ID;
	
	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "identity_ID")
	private Studentidentity studentidentity;
	private String Stud_Name;
	private String Address;
	private Date DOB;
	
	public Studente(Studentidentity studentidentity, String Stud_Name, String Address, Date DOB) {
		this.studentidentity = studentidentity;
		this.Stud_Name = Stud_Name;
		this.Address = Address;
		this.DOB = DOB;
	}

	public Studentidentity getStudentidentity() {
		return studentidentity;
	}

	public void setStudentidentity(Studentidentity studentidentity) {
		this.studentidentity = studentidentity;
	}

	public String getStud_Name() {
		return Stud_Name;
	}

	public void setStud_Name(String stud_Name) {
		Stud_Name = stud_Name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	
	public Studente() {
		
	}
	

}
