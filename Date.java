import java.io.Serializable;

public class Date implements Serializable	{
		
	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year)	{ 
		if (day > 31 || day < 0)
			throw new IllegalNumberOfDaysException("Argument for days needs to be an integer between 0 and 32, excluding 0 and 32.");
		if ((month == 2 && day >= 30) || (month == 4 && day > 30) || (month == 6 && day > 30) || (month == 9 && day > 30) || (month == 11 && day > 31))
			throw new DaysPerMonthException("The date argument does not fit the month argument.");
		if ((month == 2 && day == 29 && year % 4 != 0) || (month == 2 && day == 29 && year % 100 != 0) || (month == 2 && day == 29 && year % 400 != 0))
			throw new IllegalLeapYearException("The date, month and year arguments are not the day in a leap year.");
		else	{
			this.day = day;
			this.month = month;
			this.year = year;
		}	
	}

	public int getDay()	{
		return day;
	}

	public void setDay(int day)	{
		if (day > 31 || day < 0)
			System.out.println("Value for day is invalid.");
		if ((month == 2 && day >= 30) || (month == 4 && day > 30) || (month == 6 && day > 30) || (month == 9 && day > 30) || (month == 11 && day > 31))
			System.out.println("Invalid combination for day and month");
		if ((month == 2 && day < 30 && year % 4 != 0) || (month == 2 && day < 30 && year % 100 != 0) || (month == 2 && day < 30 && year % 400 != 0))
			System.out.println("Invalid combination of day, month and year - not a leap year combination");
		else
			this.day = day;
	}

	public int getMonth()	{
		return month;
	}

	public void setMonth(int month)	{
		if (day > 31 || day < 0)
			System.out.println("Value for day is invalid.");
		if ((month == 2 && day >= 30) || (month == 4 && day > 30) || (month == 6 && day > 30) || (month == 9 && day > 30) || (month == 11 && day > 31))
			System.out.println("Invalid combination for day and month");
		if ((month == 2 && day < 30 && year % 4 != 0) || (month == 2 && day < 30 && year % 100 != 0) || (month == 2 && day < 30 && year % 400 != 0))
			System.out.println("Invalid combination of day, month and year - not a leap year combination");
		else
			this.month = month;
	}

	public int getYear()	{
		return year;
	}

	public void setYear(int year)	{
		if (day > 31 || day < 0)
			System.out.println("Value for day is invalid.");
		if ((month == 2 && day >= 30) || (month == 4 && day > 30) || (month == 6 && day > 30) || (month == 9 && day > 30) || (month == 11 && day > 31))
			System.out.println("Invalid combination for day and month");
		if ((month == 2 && day < 30 && year % 4 != 0) || (month == 2 && day < 30 && year % 100 != 0) || (month == 2 && day < 30 && year % 400 != 0))
			System.out.println("Invalid combination of day, month and year - not a leap year combination");
		else
			this.year = year;
	}

	@Override
	public String toString()	{
		return String.format("%d\\%d\\%d", day, month, year);
	}
}

