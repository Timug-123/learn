package MavenFun.MavenFun1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class Main {

	 public static void main(String[] args) {
		 
		 String hql = "SELECT DISTINCT pr.patientName, pr.Address FROM Patientrecords pr, Patient p WHERE p.ID = p.PatientID AND p.PatientAge > 18";
         
			Patientrecords patr = new Patientrecords("Mirembe Diana", 32,  "Kampala", "Fever");
			Configuration conf = new Configuration();
			conf.configure("hibernate.cfg.xml").addAnnotatedClass(Patientrecords.class).addAnnotatedClass(Patient.class);
			SessionFactory sef = conf.buildSessionFactory();
			Session session = sef.openSession();
			Transaction transaction = session.beginTransaction(); // Start the
			session.persist(patr);
			 Query<Object[]> query = session.createQuery(hql);

	         // Execute the query
	         List<Object[]> results = query.list();
			 //List<Object[]> patientR = session.createQuery(hql).getResultList();


			// Loop through the results and print details
	        /* for (Object[] result : results) {
	             String patientName = (String) result[0];
	             String address = (String) result[1];
	             System.out.println("Patient Name: " + patientName + ", Address: " + address);
	         }*/
	         System.out.println("The result is " +results);
	         System.out.println(results.size());
			transaction.commit(); // Commit the transaction
			
			session.close(); // Close
	 }
}
