package MavenFun.MavenFun1;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Mainc {

	public static void main(String[] args) {
		Studentidentity studid = new Studentidentity();
		studid.setIdentity_owner("David Magomu");
		studid.setSchool_Name("Old Kampala S.S");
		
		Studente Stud = new Studente();
		Stud.setStud_Name("Christopher Miiro");
		Stud.setAddress("Ntinda");
		Stud.setDOB(new Date());
		Stud.setStudentidentity(studid);
		studid.setStudente(Stud);
		
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory sef = conf.buildSessionFactory();
		Session session = sef.openSession();
		Transaction transaction = session.beginTransaction(); 

		// Commit the transaction
		session.persist(Stud);
		transaction.commit();
		session.close();
		sef.close();

	}

}
