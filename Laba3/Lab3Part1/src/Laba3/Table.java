package Laba3;

public class Table extends Furniture {
    private int numBox;
    private float sqWorkArea;

    public Table() {
        super();
        numBox = 0;
        sqWorkArea = 0;
    }

    public Table(int numBox, String material) {
        super(material);
        this.numBox = numBox;
        furnitureProd();
    }

    public Table(String material, double price, int numBox, float sqWorkArea) {
        super(material, price);
        this.numBox = numBox;
        this.sqWorkArea = sqWorkArea;
        furnitureProd();
    }

    public int getNumBox() {
        return numBox;
    }

    public float getSqWorkArea() {
        return sqWorkArea;
    }

    public String furnitureProd() {
        producer = "Пинскдрев";
        return producer;
    }
}
