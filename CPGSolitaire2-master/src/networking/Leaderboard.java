package networking;

import java.sql.*;

public class Leaderboard 
{
	Connection connection = null;
	Statement statement = null;
	private String username;
	private String password;
	private String DRIVER = "com.mysql.cj.jdbc.Driver";
	private String URL = "jdbc:mysql://192.168.1.113:3306/scores_database?Timezone=America/Toronto";
	private String USERURL = "jdbc:mysql://192.168.1.113:3306/Test?serverTimezone=America/Toronto";
	boolean isSignedIn = false;
	
	/**
	 * public Leaderboard()
	 * <p>
	 * The constuctor for the Leaderboard object, which registers the JDBC driver
	 */
	public Leaderboard()
	{
		try 
		{
			Class.forName(DRIVER);
		} 
		catch(ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * public void signUp(String username, String password) throws AlreadyExistsException, SQLException
	 * <p>
	 * Creates an account for the user on the database.
	 * <p>
	 * @param username The user's chosen username
	 * @param password The user's chosen password
	 * @throws AlreadyExistsException This is thrown when the specified username has already been taken
	 * @throws SQLException This is thrown when any sort of error occurs while accessing the database
	 */
	public void signUp(String username, String password) throws AlreadyExistsException, SQLException
	{
		String sql = "create user '" + username + "'@'" + USERURL + "' identified by '" + password + "';";
		ResultSet rs;
		
		if(connection.isClosed() || connection == null)
		{
			connection = DriverManager.getConnection(USERURL, "alex", "A!ex1999");
		}
		statement = connection.createStatement();
			
		rs = statement.executeQuery("select User from mysql.user;");
			
		rs.next();
			
		while(!rs.isAfterLast())
		{
			if(rs.getString("User").equals(username))
			{
				throw new AlreadyExistsException();
			}
			rs.next();
		}
			
		statement.executeUpdate(sql);
		connection.close();
		statement.close();
		rs.close();
	}
	
	/**
	 * public void signIn(String username, String password) throws SQLException
	 * <p>
	 * Connects to the database using the specified username and password
	 * <p>
	 * @param username
	 * @param password
	 * @throws SQLException
	 */
	public void signIn(String username, String password) throws SQLException
	{
		this.username = username;
		this.password = password;
		
		if(!connection.isClosed() && connection != null)
		{
			connection.close();
		}
		
		connection = DriverManager.getConnection(URL, username, password);
	}
	
	/**
	 * public void signOut() throws SQLException
	 * <p>
	 * Disconnects from the database
	 * <p>
	 * @throws SQLException This is thrown if an error occurs while communicating with the database
	 */
	public void signOut() throws SQLException
	{
		if(connection != null)
		{
			statement.close();
			connection.close();
			connection = null;
		}
	}
	
	/**
	 * public void updateLeaderboard(long score) throws NotSignedInException, SQLException
	 * <p>
	 * Either updates the user's score in the database, or inserts their score into the database
	 * <p>
	 * WARNING: SQL HAS NOT YET BEEN TESTED, IMPLEMENT BUT EXPECT ERRORS.
	 * <p>
	 * @param score
	 * @throws NotSignedInException
	 * @throws SQLException
	 */
	public void updateLeaderboard(long score) throws NotSignedInException, SQLException
	{
		String sql = "if(select username from scores where username like '" + username + "', update scores set score = " + score + " where username = '" + username + "', insert into scores (score, username) values (" + score + ", " + username +"))";
		
		if(connection == null || connection.isClosed())
		{
			throw new NotSignedInException();
		}
		else
		{
			statement = connection.createStatement();
			statement.execute(sql);
		}
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Score[] getTopScores() throws SQLException
	{
		ResultSet scoresSet;
		Score[] scores = new Score[10];
		
		scoresSet = statement.executeQuery("select * from scores;");
		scoresSet.next();
		
		for(int i = 0; i < scores.length && !scoresSet.isAfterLast(); i++)
		{
			scores[i] = new Score(scoresSet.getLong("score"), scoresSet.getString("user"));
			scoresSet.next();
		}
		
		return scores;
	}
}
