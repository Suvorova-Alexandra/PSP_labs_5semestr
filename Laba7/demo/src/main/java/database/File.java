package database;

import java.util.ArrayList;

public class File {
    private int idfile;
    private String title;
    private int idCatalog;
    private float memory;
    private ConnectionDB connectionDB;
    public File(){
        connectionDB = ConnectionDB.getInstance();
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

    public void setMemory(float memory) {
        this.memory = memory;
    }

    public float getMemory() {
        return memory;
    }

    public void setIdfile(int idfile) {
        this.idfile = idfile;
    }

    public void insert(){
        String str = "INSERT INTO file (titleFile, memory, idsubcatalog) VALUES('" +
                this.title +"', '"+this.memory+"', '"+ this.idCatalog+"')";
        connectionDB.execute(str);
    }
    public ArrayList<File> searchFiles(String tit){
        String str = "SELECT * From file where title='"+tit+"'";
        ArrayList<String[]> result = connectionDB.getArrayResult(str);
        ArrayList<File> listInfo = new ArrayList<>();
        for (String[] items : result) {
            File info = new File();
            info.setIdCatalog(Integer.parseInt(items[3]));
            info.setTitle(items[1]);
            info.setMemory(Float.parseFloat(items[2]));
            info.setIdfile(Integer.parseInt(items[0]));
            listInfo.add(info);
        }
        return listInfo;
    }
    public boolean findFile(String tit){
        String str = "SELECT * FROM file WHERE titleFile = '" + tit + "'";
        ArrayList<String[]> result = connectionDB.getArrayResult(str);
        return result.isEmpty();
    }
}
