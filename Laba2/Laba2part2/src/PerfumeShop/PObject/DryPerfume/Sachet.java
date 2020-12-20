package PerfumeShop.PObject.DryPerfume;

public class Sachet extends DryPerf {
    private String sMaterial;
    private int sId;
    private int sNum;

public Sachet(){
    super();
    sMaterial=new String();
    generateName();
    sNum=1+sNum;
    sId=sNum;
}
    public void setsMaterial(String material) {
        this.sMaterial = material;
    }
    @Override
    protected void generateName()
    {
        Pname="Духи-саше";
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
        if(this==obj)
            return true;
        if(obj instanceof Sachet )
        {
            Sachet temp=(Sachet)obj;
            return this.sId==temp.sId && this.Pcost==temp.Pcost &&
                    this.sMaterial.equals(temp.sMaterial) &&
                    this.Pbrand.equals(temp.Pbrand) &&
                    this.Pname.equals(temp.Pname) &&
                    this.Pprice==temp.Pprice &&
                    this.Pweight==temp.Pweight &&
                    this.Pgen.equals(temp.Pgen) &&
                    this.Pcountry.equals(temp.Pcountry);

        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash=47*hash+this.sMaterial.hashCode();
        hash = 47 * hash + this.sId;
        return hash;
    }
    @Override
    public String toString()
    {
        String str=new String();
            str=super.toString()+". Материал: "+sMaterial;
        return str;
    }

    @Override
    public void printCollection() {
        System.out.println(toString());
    }

}
