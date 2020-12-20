package PerfumeShop.PObject.FluidPerfume;
import PerfumeShop.PObject.PObject;

public class FluidPerf extends PObject {
    protected int volume;
    protected int percent;
    public FluidPerf(){
        super();
        volume=0;
        percent=0;
        generateName();
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    @Override
    public void printCollection() {
        super.printCollection();
        System.out.println(toString());
    }

    @Override
    protected void generateName() {
Pname="Unknown_fluid_perfume";
    }
    @Override
    public String toString()
    {
        String str;
        str=super.toString()+". Объем:"+volume+"мл. Процент душистых веществ:"+percent+"%";
        return str;
    }

}
