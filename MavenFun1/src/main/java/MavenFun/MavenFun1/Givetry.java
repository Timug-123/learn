package MavenFun.MavenFun1;



import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Givetry {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int ID;

@Length(min = 3, max = 10, message = "Username must be between 3 and 20 characters") 

private String username;

public Givetry(String username) {
	this.username = username;
}


	public String getUsername() {
	return username;
}


public void setUsername(String username) {
	this.username = username;
}
public Givetry() {
	
}


	public static void main(String[] args) {
		Givetry Less = new Givetry("jeeeeeeeeeeeeeeeeeeeeeeeeeeeeeettttt");
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory sef = conf.buildSessionFactory();
		Session session = sef.openSession();
		Transaction transaction = session.beginTransaction(); // Start the transaction
		session.persist(Less);
		transaction.commit(); // Commit the transaction
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        // Validate the entity before persisting
        var violations = validator.validate(Less);
        
        if (violations.isEmpty()) {
            // If no validation errors, persist the entity
            session.persist(Less);
            transaction.commit(); // Commit the transaction
            System.out.println("Entity persisted successfully!");
        } else {
            // If validation fails, print out the violations
            for (var violation : violations) {
                System.out.println("Validation failed: " + violation.getMessage());
            }
        }

		session.close(); // Close the session

	}

}
