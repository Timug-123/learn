package MavenFun.MavenFun1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@EntityListeners(Annotated.class)
@Entity
@Table(name = "patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int PatientID;
	private String PatientName;
	private String Address;
	private int PatientAge;

	public Patient(String PatientName, String Address, int PatientAge) {

		this.PatientName = PatientName;
		this.Address = Address;
		this.PatientAge = PatientAge;

	}

	public Patient() {

	}

	public String getPatientName() {
		return PatientName;
	}

	public void setPatientName(String patientName) {
		PatientName = patientName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public int getPatientAge() {
		return PatientAge;
	}

	public void setPatientAge(int patientAge) {
		this.PatientAge = patientAge;
	}
	
	

	public static void main(String[] args) {
		
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory sef = conf.buildSessionFactory();
		Session session = sef.openSession();
		Transaction transaction = session.beginTransaction(); // Start the
		
		/*Patient pat = session.get(Patient.class, 402); // Load the patient with PatientID 152
		if (pat != null) {
		    pat.setAddress("Matuga");  // Change address
		    session.merge(pat);         // Persist the changes
		} else {
		    System.out.println("Patient not found!");
		}*/
		

		Patient pat = session.get(Patient.class, 402);
        
        if (pat != null) {
             
            session.delete(pat); // Remove the patient entity
        } else {
            System.out.println("Patient not found!");
        }
		transaction.commit(); // Commit the transaction
		session.close(); // Close the session

	
	
	
	}
}
