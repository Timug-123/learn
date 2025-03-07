package MavenFun.MavenFun1;






import java.time.LocalDate;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;


@Entity(name = "Form8")


public class School {
@Id
@GeneratedValue(strategy = GenerationType.TABLE)
@Column(name = "School_Name", nullable=false, unique=false)
private int Sch_ID;
private String Sch_Name;
@Transient
private String Sch_Address;
private String Ownership;
//@Temporal(TemporalType.DATE)
private LocalDate  DOC;

public School(String Sch_Name, String Sch_Address, String Ownership, LocalDate DOC) {
	//this.Sch_ID = Sch_ID;
	this.Sch_Name = Sch_Name;
	this.Sch_Address = Sch_Address;
	this.Ownership = Ownership;
	this.DOC = DOC;
	
} 
public School() {
	
}
public int getSchID() {
	return Sch_ID;
}
public String getschName() {
	return Sch_Name;
}
public String getSchAddress() {
	return Sch_Address;
}
public String getOwnership() {
	return Ownership;
}
public LocalDate getdoc() {
	return DOC;
}

/*public void setSchID(int Sch_ID) {
	this.Sch_ID = Sch_ID;	
}*/
public void setschName(String Sch_Name) {
	this.Sch_Name = Sch_Name;
}

public void setSchAddress(String Sch_Address) {
	this.Sch_Address = Sch_Address;
}
public void setOwnership(String Ownership) {
	this.Ownership = Ownership;
}

public void setdoc(LocalDate DOC) {
	this.DOC = DOC;
}

public static void main(String[] args) {
	School sch = new School("Kasubi COU", "Seeta", "Private", LocalDate.of(1984, 10, 15));
	  //sch.setschName(null);
	 
	  Configuration conf = new Configuration();
	  conf.configure("hibernate.cfg.xml");
	  SessionFactory sef = conf.buildSessionFactory();
	  Session session= sef.openSession();
	  Transaction transaction = session.beginTransaction();  // Start the transaction
	  session.persist(sch);
	  transaction.commit();  // Commit the transaction
	  session.close();  // Close the session
	 

	}

}
