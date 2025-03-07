package MavenFun.MavenFun1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "Testm14")
public class Testme {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int UserId;
	//@Column(columnDefinition = "varchar(255) default 'Muganga Paul'")
	private String fistName ="Kalungi Isaac";
	private int Age = 0;

	public Testme(String fistName, int Age) {
		this.fistName = fistName;
		this.Age = Age;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public Testme() {

	}
	
	 @PrePersist
	    public void prePersist() {
	        if (fistName == null) {
	        	fistName = "Ssegujja Keneddy";
	        }
	 }  
	public static void main(String[] args) {

		
		Testme test = new Testme();
		test.Age = 35;
		test.fistName = "Muwanguzi Simon";
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory sef = conf.buildSessionFactory();
		Session session = sef.openSession();
		Transaction transaction = session.beginTransaction(); // Start the
		session.persist(test);

		transaction.commit(); // Commit the transaction
	}

}
