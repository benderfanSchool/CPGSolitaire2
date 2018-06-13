package networking;
/**
 * AlreadyExistsException
 * <p>
 * This exception means that username has already been taken
 * <p>
 * @author gallalex111
 * @since 06/01/2018
 */
public class AlreadyExistsException extends Exception
{
	@Override
	public String getMessage()
	{
		return "The given username is already taken.";
	}
	
	@Override
	public String toString()
	{
		return "The given username is already taken.";
	}
}
