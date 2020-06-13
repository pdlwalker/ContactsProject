public class DaysPerMonthException extends RuntimeException	{
	public DaysPerMonthException()	{
		this("The date argument does not fit the month argument.");
	}

	public DaysPerMonthException(String message)	{
		super(message);
	}
}
