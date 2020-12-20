package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Requests {
    private ConnectionDB connectionDB;
    public Requests(){
        connectionDB = ConnectionDB.getInstance();
    }
    public ArrayList<String[]> leftJoinWhereSubcatalog(String tit) throws SQLException {
        String string="SELECT a.idCatalog,a.titleCatalog,b.titleSubcatalog, c.titleFile FROM catalog a \n" +
                "LEFT JOIN subcatalog b ON a.idCatalog = b.idCatalog \n" +
                "LEFT JOIN file c ON b.idsubcatalog = c.idsubcatalog WHERE b.titleSubcatalog ='"+tit+"';";
        ArrayList<String[]> result = connectionDB.getArrayResult(string);

        return result;
    }
    public ArrayList<String[]> leftJoinWhereFile(String tit) throws SQLException {
        String string="SELECT a.idCatalog,a.titleCatalog,b.titleSubcatalog, c.titleFile FROM catalog a \n" +
                "LEFT JOIN subcatalog b ON a.idCatalog = b.idCatalog \n" +
                "LEFT JOIN file c ON b.idsubcatalog = c.idsubcatalog WHERE c.titleFile ='"+tit+"';";
        ArrayList<String[]> result = connectionDB.getArrayResult(string);

        return result;
    }
    public ArrayList<String[]> leftJoinWhereCatalog(String tit) throws SQLException {
        String string="SELECT a.idCatalog,a.titleCatalog,b.titleSubcatalog, c.titleFile FROM catalog a \n" +
                "LEFT JOIN subcatalog b ON a.idCatalog = b.idCatalog \n" +
                "LEFT JOIN file c ON b.idsubcatalog = c.idsubcatalog WHERE a.titleCatalog ='"+tit+"';";
        ArrayList<String[]> result = connectionDB.getArrayResult(string);

        return result;
    }


    public ArrayList<String[]> leftJoinMemorySubcatalog(String tit) throws SQLException {
        String string="SELECT a.idCatalog,a.titleCatalog,b.titleSubcatalog, c.titleFile, c.memory FROM catalog a \n" +
                "LEFT JOIN subcatalog b ON a.idCatalog = b.idCatalog \n" +
                "LEFT JOIN file c ON b.idsubcatalog = c.idsubcatalog WHERE b.titleSubcatalog ='"+tit+"';";
        ArrayList<String[]> result = connectionDB.getArrayResult(string);


        return result;
    }
    public ArrayList<String[]> leftJoinMemoryCatalog(String tit) throws SQLException {
        String string="SELECT a.idCatalog,a.titleCatalog,b.titleSubcatalog, c.titleFile, c.memory FROM catalog a \n" +
                "LEFT JOIN subcatalog b ON a.idCatalog = b.idCatalog \n" +
                "LEFT JOIN file c ON b.idsubcatalog = c.idsubcatalog WHERE a.titleCatalog ='"+tit+"';";
        ArrayList<String[]> result = connectionDB.getArrayResult(string);


        return result;
    }
    public ArrayList<String[]> leftJoinMemoryFile(String tit) throws SQLException {
        String string="SELECT a.idCatalog,a.titleCatalog,b.titleSubcatalog, c.titleFile, c.memory FROM catalog a \n" +
                "LEFT JOIN subcatalog b ON a.idCatalog = b.idCatalog \n" +
                "LEFT JOIN file c ON b.idsubcatalog = c.idsubcatalog WHERE c.titleFile ='"+tit+"';";
        ArrayList<String[]> result = connectionDB.getArrayResult(string);


        return result;
    }
}
