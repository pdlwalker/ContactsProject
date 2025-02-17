import java.io.Serializable;

public class Contact implements Serializable, Comparable<Name>	{
	
	private Name name;
	private String homeTelephoneNumber;
	private String workTelephoneNumber;
	private String cellphoneNumber;
	private Address homeAddress;
	private Address workAddress;
	private Date dateOfBirth;
	//social media presence? Facebook, Twitter, Instagram, LinkedIn, Whatsapp
	
	public Contact(Name name, String homeTelephoneNumber, String workTelephoneNumber, String cellphoneNumber, Address homeAddress, Address workAddress, Date dateOfBirth)	{
		this.name = name;
		this.homeTelephoneNumber = homeTelephoneNumber;
		this.workTelephoneNumber = workTelephoneNumber;
		this.cellphoneNumber = cellphoneNumber;
		this.homeAddress = homeAddress;
		this.workAddress = workAddress;
		this.dateOfBirth = dateOfBirth;
	}

	public Name getName()	{
		return name;
	}

	//regex for phonenumbers and emails
	public String getHomeTelephoneNumber()	{
		return homeTelephoneNumber;
	}

	public void setHomeTelephoneNumber(String homeTelephoneNumber)	{
		this.homeTelephoneNumber = homeTelephoneNumber;
	}

	public String getWorkTelephoneNumber()	{
		return workTelephoneNumber;
	}

	public void setWorkTelephoneNumber(String workTelephoneNumber)	{
		this.workTelephoneNumber = workTelephoneNumber;
	}

	public String getCellphoneNumber()	{
		return cellphoneNumber;
	}

	public void setCellphoneNumber(String cellphoneNumber)	{
		this.cellphoneNumber = cellphoneNumber;
	}

	public Address getHomeAddress()	{
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress)	{
		this.homeAddress = homeAddress;
	}

	public Address getWorkAddress()	{
		return workAddress;
	}

	public void setWorkAddress(Address workAddress)	{
		this.workAddress = workAddress;
	}

	public Date getDateOfBirth()	{
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth)	{
		this.dateOfBirth = dateOfBirth;
	}

	@Override	
	public int compareTo(Name that)	{
		if (this.name.getLastName().compareTo(that.getLastName()) > 0)
			return 1;
		else if(this.name.getLastName().compareTo(that.getLastName()) < 0)
			return -1;	
		else if (this.name.getLastName().compareTo(that.getLastName()) == 0)	{
			if (this.name.getFirstName().compareTo(that.getFirstName()) > 0)
				return 1;
			else if (this.name.getFirstName().compareTo(that.getLastName()) < 0)
				return -1;
		}
		return 0;
	}

	@Override
	public String toString()	{
		return String.format("%s%n%n%s%n%s%n%s%n%n%s%n%s%n%s%n", name.toString(), homeTelephoneNumber, workTelephoneNumber, cellphoneNumber, homeAddress.toString(), workAddress.toString(), dateOfBirth.toString());
	}
}
