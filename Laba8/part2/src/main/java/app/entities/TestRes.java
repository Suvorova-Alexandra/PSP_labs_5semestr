package app.entities;

import java.util.ArrayList;

public class TestRes {
    private static ArrayList<String[]> res = new ArrayList<>();
    private static ArrayList<String[]> pass = new ArrayList<>();

    public TestRes(){}

    public ArrayList<String[]> getRes() {
        return res;
    }

    public void setRes(String[] res) {
        this.res.add(res);
    }

    public void setPass(String[] pass) {
        this.pass.add(pass);
        for (String[] resL : res) {
            if (resL[0].equals(pass[0])) {
                res.remove(resL);
            }
        }
    }

    public  ArrayList<String[]> getPass() {
        return pass;
    }
    public String findRes(String log){
        String str ="";
        for(String[] resL: res){
            if(resL[0].equals(log)){
                str = "0";
            }
        }
        for(String[] passL: pass){
            if(passL[0].equals(log)){
                str = passL[1];
            }
        }
        return str;
    }
}
