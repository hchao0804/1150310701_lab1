package tutorial.lab.dao.utils;

import java.sql.*;

public class JdbcUtils
{
    private static Connection connection;
    private static Statement statement;
    private static final String DATABASE_NAME = "app_1150310701";
    //private static final String USERNAME = "42j31lk332";
    //private static final String PASSWORD = "i2i2h1m4hhy1yl03x4l030h3xiwi2h1lwk3i5yhj";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    static
    {
	String d = "com.mysql.jdbc.Driver";
	try
	{
	    Class.forName(d);
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
    }
    
    public static Connection getConnection() throws SQLException
    {
	if(connection == null || connection.isClosed())
	{
		//String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3306/" + DATABASE_NAME;
		String url = "jdbc:mysql://localhost:3306/bookDB";   
	    
	    try
	    {
		connection = DriverManager.getConnection(url,USERNAME,PASSWORD);
	    }
	    catch(Exception e)
	    {
		System.out.println("数据库连接异常!");
		e.printStackTrace();
	    }
	}
	
	return connection;
    }
    
    
    public static Statement getStatement() throws SQLException
    {
	if(statement == null || statement.isClosed())
	    statement = JdbcUtils.getConnection().createStatement();
	return statement;
    }
    
    
    public static void release(ResultSet res,Statement stmt,Connection conn)
    {
	if(res != null)
	{
	    try
	    {
		res.close();
	    } 
	    catch (SQLException e)
	    {
		e.printStackTrace();
	    }
	}
	
	if(stmt != null)
	{
	    try
	    {
		stmt.close();
	    } 
	    catch (SQLException e)
	    {
		e.printStackTrace();
	    }
	}
	
	if(conn != null)
	{
	    try
	    {
		conn.close();
	    } 
	    catch (SQLException e)
	    {
		e.printStackTrace();
	    }
	}
	
    }
    
    public static void release(Object o)
    {
	try
	{
	    if(o instanceof ResultSet)
	    {
		((ResultSet)o).close();
	    }else if (o instanceof Statement)
	    {
		((Statement) o).close();
	    } else if (o instanceof Connection)
	    {
		((Connection) o).close();
	    }
	    
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
    }
    
    
}
