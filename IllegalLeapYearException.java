public class IllegalLeapYearException extends RuntimeException {
	public IllegalLeapYearException()	{
		this("The date, month and year are not a day in a leap year");
	}

	public IllegalLeapYearException(String message)	{
		super(message);
	}
}
