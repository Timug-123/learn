package MavenFun.MavenFun1;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private int Stud_ID;
private String Stud_Name;
private int Stud_Age;
public Student (String Stud_Name, int Stud_Age) {
	
	this.Stud_Name = Stud_Name;
	this.Stud_Age = Stud_Age;
}

	

public String getStud_Name() {
	return Stud_Name;
}


public void setStud_Name(String Stud_Name) {
	this.Stud_Name = Stud_Name;
}


public int getStud_Age() {
	return Stud_Age;
}


public void setStud_Age(int Stud_Age) {
	this.Stud_Age = Stud_Age;
}


}


