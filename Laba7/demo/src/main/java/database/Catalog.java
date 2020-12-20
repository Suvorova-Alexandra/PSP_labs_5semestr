package database;

import java.util.ArrayList;

public class Catalog {
    private int idCatalog;
    private String title;
    private ConnectionDB connectionDB;
    public Catalog(){
        connectionDB = ConnectionDB.getInstance();
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getTitle() {
        return title;
    }

    public void setIdCatalog(int idCatalog) {
        this.idCatalog = idCatalog;
    }

    public void insert(){
        String str = "INSERT INTO catalog (titleCatalog) VALUES('" +
                this.title +"')";
        connectionDB.execute(str);
    }
    public ArrayList<Catalog> searchCatalogs(String tit){
        String str = "SELECT * From catalog where titleCatalog='"+tit+"'";
        ArrayList<String[]> result = connectionDB.getArrayResult(str);
        ArrayList<Catalog> listInfo = new ArrayList<>();
        for (String[] items : result) {
            Catalog info = new Catalog();
            info.setIdCatalog(Integer.parseInt(items[0]));
            info.setTitle(items[1]);
            listInfo.add(info);
        }
        return listInfo;
    }
    public ArrayList<Catalog> selectAll() {
        String str = "SELECT * From multiplier";
        ArrayList<String[]> result = connectionDB.getArrayResult(str);
        ArrayList<Catalog> listInfo = new ArrayList<>();
        for (String[] items : result) {
            Catalog info = new Catalog();
            info.setTitle(items[1]);
            info.setIdCatalog(Integer.parseInt(items[0]));
            listInfo.add(info);
        }
        return listInfo;
    }
    public boolean findCatalog(String tit){
        String str = "SELECT * FROM catalog WHERE titleCatalog = '" + tit + "'";
        ArrayList<String[]> result = connectionDB.getArrayResult(str);
        return result.isEmpty();
    }
}
