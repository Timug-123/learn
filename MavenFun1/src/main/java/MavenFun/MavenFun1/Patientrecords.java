package MavenFun.MavenFun1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient_records")
public class Patientrecords {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patientID;
	private String patientName;
	private int patientAge;
	private String Address;
	private String Sickness;

	public Patientrecords(String patientName, int patientAge, String Address, String Sickness) {

		this.patientName = patientName;
		this.patientAge = patientAge;
		this.Address = Address;
		this.Sickness = Sickness;

	}

	public Patientrecords() {

	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getSickness() {
		return Sickness;
	}

	public void setSickness(String sickness) {
		Sickness = sickness;
	}

	public static void main(String[] args) {

		//String hql = "From Patient";
		
		 Patientrecords pat = new Patientrecords("Maria Gorret ", 24, "Gayaza", "Headace");
		 Configuration conf =new Configuration(); conf.configure("hibernate.cfg.xml"); 
		 SessionFactory sef = conf.buildSessionFactory();
		 Session session = sef.openSession();
		 Transaction transaction = session.beginTransaction(); // Start the
		 session.persist(pat);
		 transaction.commit(); // Commit the transaction
		 System.out.println("Patient added successfully!"); session.close(); // Close
	}
}