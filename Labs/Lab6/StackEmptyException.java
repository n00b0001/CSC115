public class StackEmptyException extends RuntimeException
{
	public StackEmptyException()
	{
		super();
	}

	public StackEmptyException(String msg)
	{
		super(msg);
	}

	public String getMessage()
	{
		return super.getMessage();
	}
}