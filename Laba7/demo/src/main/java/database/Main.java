package database;

import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ConnectionDB connect=new ConnectionDB();
        try {

         if (!connect.getConnection().isClosed()) {
                System.out.println("\n\tСоединение с БД установлено!");
                Subcatalog catal=new Subcatalog();
                ResultSet list= catal.leftJoin();
                int flag=0;
             while (list.next()) {
                 int id = list.getInt("idsubcatalog");
                 String name = list.getString("titleSubcatalog");
                 String fileName = list.getString("titleCatalog");
                 String country = list.getString("titleFile");

                 System.out.println("Sub id: " + id);
                 System.out.println("Sub title: " + name);
                 System.out.println("File title: " + country);
                 System.out.println("Catalog nem: " + fileName);
                 System.out.println("================================");
                 flag++;
             }
          }
            connect.close();
            System.out.println("\n\tСоединение с БД закрыто!");
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println("\nСоединение с БД не установлено!");
        }
    }
}