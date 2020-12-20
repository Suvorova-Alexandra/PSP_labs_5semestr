package PerfumeShop;

import PerfumeShop.PObject.DryPerfume.Sachet;
import PerfumeShop.PObject.DryPerfume.SolidPerfume;
import PerfumeShop.PObject.FluidPerfume.Colonge;
import PerfumeShop.PObject.FluidPerfume.EauDeToilette;
import PerfumeShop.PObject.FluidPerfume.Essence;
import PerfumeShop.Collection.Collection;




public class MainClass {
    public static void main(String[] args) {
        Sachet sachet = new Sachet();
        SolidPerfume solperf = new SolidPerfume();
        Colonge colonge = new Colonge();
        EauDeToilette toilette = new EauDeToilette();
        Essence essence = new Essence();

        sachet.setPbrand("Givenchy");
        sachet.setPcountry("USA");
        sachet.setPgen("женские");
        sachet.setCost(130);
        sachet.setPweight(26);
        sachet.setsMaterial("ткань");

        colonge.setPbrand("Surprise");
        colonge.setMission("гигиенический");
        colonge.setPcountry("Россия");
        colonge.setPgen("мужской");
        colonge.setCost(50);
        colonge.setPercent(3);
        colonge.setVolume(250);

        solperf.setPbrand("Sunlight");
        solperf.setPcountry("Китай");
        solperf.setPgen("женский");
        solperf.setCost(237.9);
        solperf.setPweight(255);
        solperf.setDpForm("Карандаш");

        Collection col1= new Collection();
        col1.addPerfume(sachet);
        col1.addPerfume(colonge);
        col1.addPerfume(solperf);
        col1.countPrice();
        col1.printCollection();



    }
}
