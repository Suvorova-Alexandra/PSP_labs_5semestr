package PerfumeShop.PObject.FluidPerfume;

public class Colonge extends FluidPerf {
    private String mission;
    private int cId;
    private int cNum;
    public Colonge(){
        super();
        mission=new String();
        generateName();
        cNum=1+cNum;
        cId=cNum;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }
    @Override
    protected void generateName()
    {
        Pname="Одеколон";
    }
    @Override
    public String toString()
    {
        String str=new String();
        str=super.toString()+". Предназначение:"+mission;
        return str;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
        if(this==obj)
            return true;
        if(obj instanceof Colonge )
        {
            Colonge temp=(Colonge)obj;
            return this.cId==temp.cId && this.Pcost==temp.Pcost &&
                    this.Pbrand.equals(temp.Pbrand) &&
                    this.Pname.equals(temp.Pname) &&
                    this.Pgen.equals(temp.Pgen) &&
                    this.Pcountry.equals(temp.Pcountry) &&
                    this.mission.equals(temp.mission) &&
                    this.Pprice==temp.Pprice &&
                    this.volume==temp.volume &&
                    this.percent==temp.percent;

        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 42 * hash + this.mission.hashCode();
        hash = 42 * hash + this.cId;
        return hash;
    }

    @Override
    public void printCollection() {
        super.printCollection();
        System.out.println(toString());
    }
}
