package Laba3Part2;

public class Bookcase implements Furniture, Object {
    private int width;
    private int height;
    private int depth;
    private String producer;
    private double price;
    private String material;

    public Bookcase() {
        price = 0.0;
        material = "";
        width = 0;
        height = 0;
        depth = 0;
    }

    public Bookcase(int width, int height, String material) {
        price = 0.0;
        this.material = material;
        this.width = width;
        this.height = height;
        depth = 0;
        furnitureProd();
    }

    public Bookcase(String material, double price, int width, int height, int depth) {
        this.material = material;
        this.price = price;
        furnitureProd();
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    @Override
    public String furnitureProd() {
        producer = "BookCase Production";
        return producer;
    }

    @Override
    public void print() {
        System.out.println("Шкаф. Материал: " + material + ". Производитель: " + producer + ". Цена: " + price +
                "бел.р. Размер: " + width + "x" + height + "x" + depth + "см.");
    }
}
