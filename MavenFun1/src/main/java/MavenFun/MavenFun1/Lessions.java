package MavenFun.MavenFun1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class Lessions {
	private String StudName;
	@Enumerated(EnumType.STRING)
	private Weekdays DOS;
	@Id
	private int LessionID;
	private String LessionName;

	public String getLessionName() {
		return LessionName;
	}

	public void setLessionName(String lessionName) {
		LessionName = lessionName;
	}

	public String getStudName() {
		return StudName;
	}

	public void setStudName(String studName) {
		StudName = studName;
	}

	public Weekdays getDOS() {
		return DOS;
	}

	public void setDOS(Weekdays dOS) {
		DOS = dOS;
	}

	public int getLessionID() {
		return LessionID;
	}

	public void setLessionID(int LessionID) {
		this.LessionID = LessionID;
	}

	public Lessions(String LessionName, String StudName, Weekdays DOS, int LessionID) {
		this.LessionName = LessionName;
		this.StudName = StudName;
		this.DOS = DOS;
		this.LessionID = LessionID;
	}

	public static void main(String[] args) {
		Lessions Less = new Lessions("Intro to Java", "Timothy Buyondo", Weekdays.MONDAY, 1);
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory sef = conf.buildSessionFactory();
		Session session = sef.openSession();
		Transaction transaction = session.beginTransaction(); // Start the transaction
		session.persist(Less);
		transaction.commit(); // Commit the transaction
		session.close(); // Close the session
	}

}
