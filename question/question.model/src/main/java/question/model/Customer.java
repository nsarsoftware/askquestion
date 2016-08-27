package question.model;

public class Customer {
private Long tckn;
private String firstName;
private String lastName;



public Long getTckn() {
	return tckn;
}
public void setTckn(Long tckn) {
	this.tckn = tckn;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String fullName(){
	return firstName+""+lastName;
	}
}
