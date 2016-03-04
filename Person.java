package postoffice;

public abstract class Person {
	private String firstName;
	private String lastName;
	private PostOffice office;

	public Person(String name, String lastName, PostOffice office) {
		this.setFirstName(name);
		this.setLastName(lastName);
		this.setOffice(office);
	}

	public String getFirstName() {
		return firstName;
	}

	private void setFirstName(String firstName) {
		if (firstName != null && firstName.length() > 0)
			this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	private void setLastName(String lastName) {
		if (lastName != null && lastName.length() > 0)
			this.lastName = lastName;
	}
	
	public PostOffice getOffice(){
		return this.office;
	}
	
	private void setOffice(PostOffice office){
		if(office!=null){
			this.office=office;
		}
	}

}
