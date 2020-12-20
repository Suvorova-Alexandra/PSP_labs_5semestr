package app.DB;

import javax.naming.NamingException;
import java.util.ArrayList;

public class Users {
    private int idUser;
    private String log;
    private String pass;
    private String role;
    private DBConnection connectionDB;
    public Users() throws NamingException {
        connectionDB = DBConnection.getInstance();
    }

    public String getLog() {
        return log;
    }

    public String getPass() {
        return pass;
    }

    public String getRole() {
        return role;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void insert(){
        String str = "INSERT INTO user (login, pass, role) VALUES('" +
                this.log + "', '" +this.pass +"', '"+this.role+"')";
        connectionDB.execute(str);
    }

    public String findUser(){
         String str = "SELECT * From user Where login = '" + this.log +
                "' and pass = '" + this.pass + "'";
        ArrayList<String[]> result = connectionDB.getArrayResult(str);
        String status = "";
        for (String[] item: result)
            status = item[1];
        return status;
    }
}
