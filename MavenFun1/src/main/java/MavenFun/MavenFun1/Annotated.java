package MavenFun.MavenFun1;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;

import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

public class Annotated {
	@PrePersist
	public void beforePersist(Patient pat) {
		System.out.println("Before persist: " + pat.getPatientName());
	}

	@PreUpdate
	public void updateme(Patient pat) {
		System.out.println("Before updating patient...");

		if (pat.getAddress() == "Matuga") {
			pat.setAddress("Kawaala"); // Modify address before updating
		}

	}
	 @PreRemove
	    public void beforeRemove(Patient pat) {
	        System.out.println("Before removing patient: " + pat.getPatientName());
	    }
}
