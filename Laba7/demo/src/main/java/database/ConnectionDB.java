package database;

import java.sql.*;
import java.util.ArrayList;

public class ConnectionDB {
    private static final String USERNAME = "Sasha";
    private static final String PASSWORD = "Sasha2001!";
    private static final String URL = "jdbc:mysql://localhost:3306/directories?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";
    private static int idClient;
    private Connection connection;
    private Statement statement;
    ArrayList<String[]> masResult;
    private ResultSet resultSet;
    private static ConnectionDB instance;
    public ConnectionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");;
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Problem with JDBC Driver");
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return connection;
    }
    public void execute(String query) {
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ResultSet executeQuer(String query) throws SQLException {
        ResultSet result= statement.executeQuery(query);
        return result;
    }

    public ArrayList<String[]> getArrayResult(String str){
        masResult = new ArrayList<String[]>();
        try {
            resultSet = statement.executeQuery(str);
            int count = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                String[] arrayString = new String[count];
                for (int i = 1;  i <= count; i++)
                    arrayString[i - 1] = resultSet.getString(i);

                masResult.add(arrayString);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return masResult;
    }
    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

public static synchronized ConnectionDB getInstance() {
    if (instance == null) {
        instance = new ConnectionDB();
    }
    return instance;
}
}
