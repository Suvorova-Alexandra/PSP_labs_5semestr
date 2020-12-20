package PerfumeShop.PObject;
import PerfumeShop.Essence_int;



abstract public class PObject implements Essence_int {
    protected String Pname;
    protected String Pbrand;
    protected double Pprice;
    protected double Pcost;
    protected String Pcountry;
    protected String Pgen;
    public PObject(){
        Pname=new String();
        Pbrand=new String();
        Pcountry=new String();
        Pgen=new String();
        Pprice=0.0;
        Pcost=0.0;
    }
    public void setPbrand(String brand){
        Pbrand=brand;
    }
    public void setPcountry(String country){
        Pcountry=country;
    }
    public void setPgen(String gen){
        Pgen=gen;
    }
    protected void setPrice()
    {
        Pprice=countPrice();
    }
    public void setCost(double cost)
    {
        Pcost=cost;
        setPrice();
    }
    public double countPrice()//Подсчёт отпускной цены на основе себестоимости
    {
        int price;
        price=(int) ((Pcost*1.2)*1.2);
        return price;
    }

    public double getPcost() {
        return Pcost;
    }

    public double getPprice() {
        return Pprice;
    }

    abstract protected void generateName();

    public void printCollection(){
        System.out.println(toString());
    }
    @Override
    public String toString()
    {
        String str=new String();
        str=Pname+". Брэнд: "+Pbrand+". Себестоимость:"+Pcost+"у.е. Цена: "+Pprice+"у.е. Страна производства: "+Pcountry+". Пол: "+Pgen;
        return str;
    }


}
