import java.io.Serializable;

public class Address implements Serializable	{

	private String streetAddress;
	private String suburb;
	private String city;
	private String province;
	private String postalCode;

	public Address (String streetAddress, String suburb, String city, String province, String postalCode)	{
		this.streetAddress = streetAddress;
		this.suburb = suburb;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
	}	

	public String getStreetAddress()	{
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress)	{
		this.streetAddress = streetAddress;
	}

	public String getSuburb()	{
		return suburb;
	}

	public void setSuburb(String suburb)	{
		this.suburb = suburb;
	}

	public String getCity()	{
		return city;
	}

	public void setCity(String city)	{
		this.city = city;
	}

	public String getProvince()	{
		return province;
	}

	public void setProvince(String province)	{
		this.province = province;
	}

	public String getPostalCode()	{
		return postalCode;
	}

	public void setPostalCode(String postalCode)	{
		this.postalCode = postalCode;
	}

	public String toString()	{
		return String.format("%s%n%s%n%s%n%s%n%s%n", streetAddress, suburb, city, province, postalCode);
	}
}
