package networking;

/**
 * AlreadyExistsException
 * <p>
 * This exception means that the user hasn't signed in
 * <p>
 * @author gallalex111
 * @since 06/01/2018
 */
public class NotSignedInException extends Exception
{
	@Override
	public String getMessage()
	{
		return "You are not signed in.";
	}
}
