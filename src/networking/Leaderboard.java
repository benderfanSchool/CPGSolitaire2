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
	
	public void signUp(String username, String password) throws AlreadyExistsException, SQLException
	{
		String sql = "create user '" + username + "'@'" + USERURL + "' identified by '" + password + "';";
		ResultSet rs;
		
		connection = DriverManager.getConnection("alex", "A!ex1999", USERURL);
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
	
	public void signIn(String username, String password) throws SQLException
	{
		this.username = username;
		this.password = password;
		
		if(connection.isClosed() || connection == null)
		{
			connection = DriverManager.getConnection(URL, username, password);
		}
	}
	
	public void updateLeaderboard(long score) throws NotSignedInException, SQLException
	{
		String sql = "";
		
		if(connection == null || connection.isClosed())
		{
			throw new NotSignedInException();
		}
		else
		{
			
		}
	}
	
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
	
	public void close() throws SQLException
	{
			connection.close();
			statement.close();
	}
}
