package PerfumeShop.PObject.FluidPerfume;

public class Essence extends FluidPerf {
    private boolean Phard;
    private int esId;
    private int esNum;
    public Essence(){
        super();
        Phard=false;
        generateName();
        esNum=1+esNum;
        esId=esNum;
    }

    public void setPhard() {
        Phard = true;
    }
    @Override
    protected void generateName()
    {
        Pname="Духи";
    }
    @Override
    public String toString()
    {
        String str=new String();
        if(Phard)
            str=super.toString()+". Тяжелый аромат.";
        else
            str=super.toString()+". Легкий аромат.";
        return str;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
        if(this==obj)
            return true;
        if(obj instanceof Essence )
        {
            Essence temp=(Essence)obj;
            return this.esId==temp.esId && this.Pcost==temp.Pcost &&
                    this.Pbrand.equals(temp.Pbrand) &&
                    this.Pname.equals(temp.Pname) &&
                    this.Pgen.equals(temp.Pgen) &&
                    this.Pcountry.equals(temp.Pcountry) &&
                    this.Pprice==temp.Pprice &&
                    this.volume==temp.volume &&
                    this.percent==temp.percent;

        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
       hash = 47 * hash + (this.Phard? 1:0);
        hash = 47 * hash + this.esId;
        return hash;
    }

    @Override
    public void printCollection() {
        super.printCollection();
        System.out.println(toString());
    }
}

