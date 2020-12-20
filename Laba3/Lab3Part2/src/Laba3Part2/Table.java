package Laba3Part2;

public class Table implements Furniture, Object {
    private int numBox;
    private float sqWorkArea;
    protected String producer;
    protected double price;
    protected String material;

    public Table(String material, double price, int numBox, float sqWorkArea) {


        this.numBox = numBox;
        this.sqWorkArea = sqWorkArea;
        this.material = material;
        this.price = price;
        furnitureProd();
    }

    @Override
    public String furnitureProd() {
        producer = "Table Production";
        return producer;
    }

    @Override
    public void print() {
        System.out.println("Стол. Материал: " + material + " Производитель: " + producer + " Цена: " + price +
                "бел.р. Количество ящиков: " + numBox + " Площадь рабочей поверхности: " + sqWorkArea + " кв.см.");

    }
}
