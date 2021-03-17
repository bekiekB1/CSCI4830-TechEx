package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeeRegistrationInfo")
public class Employeekarki {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Integer id;
   
   @Column(name = "FirstName")
   private String FirstName;
   
   @Column(name = "LastName")
   private String LastName;
   
   @Column(name = "UserName")
   private String UserName;
   
   @Column(name = "Password")
   private String Password;
   
   @Column(name = "Email")
   private String Email;


   public Employeekarki() {
   }


public Employeekarki(String firstname, String lastName, String userName, String password, String email) {
	super();
	FirstName = firstname;
	LastName = lastName;
	UserName = userName;
	Password = password;
	Email = email;
}


public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}


public String getFirstName() {
	return FirstName;
}


public void setFirstName(String firstName) {
	FirstName = firstName;
}


public String getLastName() {
	return LastName;
}


public void setLastName(String lastName) {
	LastName = lastName;
}


public String getUserName() {
	return UserName;
}


public void setUserName(String userName) {
	UserName = userName;
}


public String getPassword() {
	return Password;
}


public void setPassword(String password) {
	Password = password;
}


public String getEmail() {
	return Email;
}


public void setEmail(String email) {
	Email = email;
}


@Override
public String toString() {
	return "Employeekarki [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", UserName=" + UserName
			+ ", Password=" + Password + ", Email=" + Email + "]";
}

   

}