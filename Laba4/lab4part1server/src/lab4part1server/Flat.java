package lab4part1server;
import java.io.*;
public class Flat {
    private String address;
    private int cost;
    Flat(){
        address="";
        cost=0;
    }
    Flat(int cost,String address){
        this.address=address;
        this.cost=cost;
    }
    int getCost(){
        return this.cost;
    }
    String getAddress(){
        return this.address;
    }

    @Override
    public String toString() {
        String str=new String();
        str="Адрес: "+address+"; стоимость: "+cost+".\n";
        return str;
    }
}
