import java.io.Serializable;

public class Name implements Serializable	{
	private String firstName;
	private String lastName;

	public Name(String firstName, String lastName)	{
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName()	{
		return firstName;
	}

	public void setFirstName(String firstName)	{
		this.firstName = firstName;
	}

	public String getLastName()	{
		return lastName;
	}

	public void setLastName(String lastName)	{
		this.lastName = lastName;
	}

	public boolean equals(Name name)	{
		boolean isEqual = false;
		isEqual = (this.getFirstName().equals(name.getFirstName())) && (this.getLastName().equals(name.getLastName()));
		return isEqual;
	}

	@Override
	public String toString()	{
		return String.format("%s %s", firstName, lastName);
	}
}
