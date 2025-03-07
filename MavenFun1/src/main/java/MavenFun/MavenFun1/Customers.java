package MavenFun.MavenFun1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "Mycustomers")
public class Customers {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)	
private int CustomerID;
private String CustomerName;
private String City;
private String Country;
private String PhoneNo;

public Customers(String CustomerName, String City, String Country, String PhoneNo) {
	
	this.CustomerName = CustomerName;
	this.City = City;
	this.Country = Country;
	this.PhoneNo = PhoneNo;
}

	public String getCustomerName() {
	return CustomerName;
}

public void setCustomerName(String customerName) {
	CustomerName = customerName;
}

public String getCity() {
	return City;
}

public void setCity(String city) {
	City = city;
}

public String getCountry() {
	return Country;
}

public void setCountry(String country) {
	Country = country;
}

public String getPhoneNo() {
	return PhoneNo;
}

public void setPhoneNo(String phoneNo) {
	PhoneNo = phoneNo;
}
public Customers() {
	
}
	public static void main(String[] args) {
	
		 //Customers Cust = new Customers("Kiddu Godfrey","Fortportal", "Uganda", "+256784676998");
		 Configuration conf =new Configuration(); conf.configure("hibernate.cfg.xml"); 
		 SessionFactory sef = conf.buildSessionFactory();
		 Session session = sef.openSession();
		 Transaction transaction = session.beginTransaction(); // Start the
		 //session.persist(Cust);
		 Query query = session.createQuery("FROM Customers");

		 query.setFirstResult(0); // Starting point

		 query.setMaxResults(3); // Maximum number of records

		 List<Customers> cust1 = query.list();
		 System.out.println(cust1.size());
		 transaction.commit(); // Commit the transaction
		 //System.out.println("Customer details added successfully!"); session.close();
	}

}
