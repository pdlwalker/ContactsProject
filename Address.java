import java.io.Serializable;

public class Address implements Serializable	{

	private int houseNumber;
	private String roadName;
	private String roadType;
	private String suburb;
	private String city;
	private String province;
	private String postalCode;

	public Address (int houseNumber, String roadName, String roadType, String suburb, String city, String province, String postalCode)	{
		this.houseNumber = houseNumber;
		this.roadName = roadName;
		this.roadType = roadType;
		this.suburb = suburb;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
	}	

	public int getHouseNumber()	{
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber)	{
		this.houseNumber = houseNumber;
	}

	public String getRoadName()	{
		return roadName;
	}

	public void setRoadName(String roadName)	{
		this.roadName = roadName;
	}

	public String getRoadType()	{
		return roadType;
	}

	public void setRoadType(String roadType)	{
		this.roadType = roadType;
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
		return String.format("%s %s %s%n%s%n%s%n%s%n%s%n%s", houseNumber, roadName, roadType, suburb, city, province, postalCode);
	}
}
