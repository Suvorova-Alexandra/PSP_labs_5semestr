package Laba3Part2;

public class Stool extends Chair {
    public Stool(String material, double price, boolean backControl) {
        super(material, price, backControl);
    }

    @Override
    public void print() {
        System.out.println("Стул. Материал: " + material + ". Производитель: " + producer + ". Цена: " + price +
                "бел.р.");
    }

    @Override
    public String furnitureProd() {
        producer = "Stool Production";
        return producer;
    }
}
