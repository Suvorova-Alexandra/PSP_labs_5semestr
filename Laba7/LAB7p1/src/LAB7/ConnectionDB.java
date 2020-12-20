package LAB7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDB {
    private Connection myConnection;

    public ConnectionDB(){}

    public void init()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            myConnection= DriverManager.getConnection("jdbc:mysql://localhost/javabd?useUnicode=true&serverTimezone=UTC", "Sasha", "Sasha2001!");
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
    }

    public Connection getMyConnection()
    {
        return myConnection;
    }

    public void close(ResultSet rs)
    {
        if(rs !=null)
        {
            try
            {
                rs.close();
            }
            catch(Exception e){}
        }
    }

    public void close(java.sql.Statement stmt)
    {
        if(stmt !=null)
        {
            try
            {
                stmt.close();
            }
            catch(Exception e){}
        }
    }

    public void destroy()
    {
        if(myConnection !=null)
        {
            try
            {
                myConnection.close();
            }
            catch(Exception e){}
        }
    }

}
