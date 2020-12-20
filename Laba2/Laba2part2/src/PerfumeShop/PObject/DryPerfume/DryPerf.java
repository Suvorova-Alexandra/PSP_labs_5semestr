package PerfumeShop.PObject.DryPerfume;
import PerfumeShop.PObject.PObject;

public class DryPerf extends PObject {
    protected int Pweight;
    public DryPerf(){
        super();
        Pweight=0;
        generateName();
    }
    public void setPweight(int weight){
        Pweight=weight;
    }
    @Override
    protected void generateName() {
     Pname="Unknown_dry_perfume";
    }

    @Override
    public void printCollection() {
        super.printCollection();
        System.out.println(toString());
    }
    @Override
    public String toString()
    {
        String str=new String();
        str=super.toString()+". Вес:"+Pweight+"мг";
        return str;
    }

}
