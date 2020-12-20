package PerfumeShop.PObject.FluidPerfume;

public class EauDeToilette extends FluidPerf {
    private String scentNotes;
    private int eNum;
    private int eId;
    public EauDeToilette(){
        super();
        scentNotes=new String();
        generateName();
        eNum=1+eNum;
        eId=eNum;

    }

    public void setScentNotes(String scentNotes) {
        this.scentNotes = scentNotes;
    }
    @Override
    protected void generateName()
    {
        Pname="Туалетная вода";
    }
    @Override
    public String toString()
    {
        String str=new String();
        str=super.toString()+". Ноты аромата:"+scentNotes;
        return str;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
        if(this==obj)
            return true;
        if(obj instanceof EauDeToilette )
        {
            EauDeToilette temp=(EauDeToilette)obj;
            return this.eId==temp.eId && this.Pcost==temp.Pcost &&
                    this.Pbrand.equals(temp.Pbrand) &&
                    this.Pname.equals(temp.Pname) &&
                    this.Pgen.equals(temp.Pgen) &&
                    this.Pcountry.equals(temp.Pcountry) &&
                    this.scentNotes.equals(temp.scentNotes) &&
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
        hash = 83 * hash + this.scentNotes.hashCode();
        hash = 83 * hash + this.eId;
        return hash;
    }

    @Override
    public void printCollection() {
        super.printCollection();
        System.out.println(toString());
    }
}
