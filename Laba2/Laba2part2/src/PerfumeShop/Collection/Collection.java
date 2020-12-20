package PerfumeShop.Collection;

import PerfumeShop.Essence_int;
import PerfumeShop.PObject.FluidPerfume.Essence;
import PerfumeShop.PObject.PObject;
import java.util.*;

public class Collection implements Essence_int {
private List<PObject> array=new ArrayList<>();
    private double cost;
    private double price;
    private static int collectNum=0;
public Collection(){
    array = new ArrayList<PObject> ();
    collectNum=1+collectNum;
}
    public void addPerfume(PObject obj)
    {
        array.add(obj);
    }
    public void printCollection()
    {
        int i=1;
        Iterator it=array.iterator();
        System.out.println("=================================================");
        while(it.hasNext())
        {
            System.out.println(i+")"+(it.next()).toString());
            i=i+1;
        }
        System.out.println();
        System.out.println("Себестоимость коллекции предметов:"+cost+" Цена:"+price);
        System.out.println("=================================================");
    }
    @Override
    protected void finalize()
    {
        try {
            super.finalize();
        } catch (Throwable ex) {
            System.err.println("Ошибка при удалении объекта");
        }
        collectNum=collectNum-1;
    }

    @Override
    public double countPrice() {
        double tempPrice=0, tempCost=0;
        Iterator it=array.iterator();
        PObject obj;
        while(it.hasNext())
        {
            obj=(PObject)it.next();
            tempCost=tempCost+obj.getPcost();
            tempPrice=tempPrice+obj.getPprice();
        }
        cost=tempCost;
        price=tempPrice;
        return tempPrice;
    }



}
