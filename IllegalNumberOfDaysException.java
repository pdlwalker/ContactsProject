public class IllegalNumberOfDaysException extends RuntimeException	{
	public IllegalNumberOfDaysException()	{
		this("The integer argument for date must be more than zero and less than 32.");
	}

	public IllegalNumberOfDaysException(String message)	{
		super(message);
	}
}
