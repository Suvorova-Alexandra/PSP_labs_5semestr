package Laba3;

public class Bookcase extends Furniture {
    private int width;
    private int height;
    private int depth;

    public Bookcase() {
        super();
        width = 0;
        height = 0;
        depth = 0;
    }

    public Bookcase(int width, int height, String material) {
        super(material);
        this.width = width;
        this.height = height;
        furnitureProd();
    }

    public Bookcase(String material, double price, int width, int height, int depth) {
        super(material, price);
        furnitureProd();
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String furnitureProd() {
        producer = "Ami";
        return producer;
    }
}
