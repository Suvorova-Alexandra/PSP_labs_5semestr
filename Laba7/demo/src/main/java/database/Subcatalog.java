package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Subcatalog {

    private int idSubCatalog;
    private String title;
    private int idCatalog;
    private ConnectionDB connectionDB;
    public Subcatalog(){
        connectionDB = ConnectionDB.getInstance();
    }

    public void setIdSubCatalog(int idSubCatalog) {
        this.idSubCatalog = idSubCatalog;
    }

    public void setIdCatalog(int idCatalog) {
        this.idCatalog = idCatalog;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getIdCatalog() {
        return idCatalog;
    }
    public void insert(){
        String str = "INSERT INTO subcatalog (titleSubcatalog, idCatalog) VALUES('" +
                this.title +"', '"+ this.idCatalog+"')";
        connectionDB.execute(str);
    }
    public ArrayList<Subcatalog> searchSubcatalogs(String tit) {
        String str = "SELECT * From subcatalog where titleSubcatalog='" + tit + "'";
        ArrayList<String[]> result = connectionDB.getArrayResult(str);
        ArrayList<Subcatalog> listInfo = new ArrayList<>();
        for (String[] items : result) {
            Subcatalog info = new Subcatalog();
            info.setIdCatalog(Integer.parseInt(items[2]));
            info.setTitle(items[1]);
            info.setIdSubCatalog(Integer.parseInt(items[0]));
            listInfo.add(info);

        }
        return listInfo;
    }
    public boolean findSubcatalog(String tit){
        String str = "SELECT * FROM subcatalog WHERE titleSubcatalog = '" + tit + "'";
        ArrayList<String[]> result = connectionDB.getArrayResult(str);
        return result.isEmpty();
    }
    public ResultSet leftJoin() throws SQLException {
        String string="SELECT a.idCatalog,a.titleCatalog,b.titleSubcatalog, c.titleFile FROM catalog a \n" +
                "LEFT JOIN subcatalog b ON a.idCatalog = b.idCatalog \n" +
                "LEFT JOIN file c ON b.idsubcatalog = c.idsubcatalog ;";
        ResultSet result = connectionDB.executeQuer(string);

        return result;
    }

}
