package PerfumeShop.PObject.DryPerfume;

public class SolidPerfume extends DryPerf {
    private String dpForm;
    private int dpId;
    private int dpNum;
    public SolidPerfume(){
        super();
        dpForm=new String();
        dpNum=1+dpNum;
        dpId=dpNum;
    }
    public void setDpForm(String dpForm) {
        this.dpForm = dpForm;
    }
    @Override
    protected void generateName()
    {
        Pname="Твердые духи";
    }
    @Override
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
        if(this==obj)
            return true;
        if(obj instanceof SolidPerfume)
        {
            SolidPerfume temp=(SolidPerfume)obj;
            return  this.dpId==temp.dpId && this.dpForm.equals(temp.dpForm) &&
                    this.Pcost==temp.Pcost &&
                    this.Pbrand.equals(temp.Pbrand) &&
                    this.Pname.equals(temp.Pname) &&
                    this.Pprice==temp.Pprice &&
                    this.Pweight==temp.Pweight &&
                    this.Pgen.equals(temp.Pgen) &&
                    this.Pcountry.equals(temp.Pcountry)
                   ;
        }
        else return false;

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.dpForm.hashCode();
        hash = 31 * hash + this.dpId;
        return hash;
    }
    @Override
    public String toString()
    {
        String str;
        str=super.toString()+". Форма:"+dpForm;
        return str;
    }

}
