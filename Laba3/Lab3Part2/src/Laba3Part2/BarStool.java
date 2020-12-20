package Laba3Part2;

public class BarStool extends Chair {
    public BarStool(String material, double price, boolean backControl) {
        super(material, price, backControl);

    }

    @Override
    public void print() {
        System.out.println("Барный стул. Материал: " + material + ". Производитель: " + producer + ". Цена: " + price +
                "бел.р.");
    }

    @Override
    public String furnitureProd() {
        producer = "Bar Stool Production";
        return producer;
    }
}
