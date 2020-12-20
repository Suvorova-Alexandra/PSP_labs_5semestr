package Laba3;

public abstract class Furniture {
    protected double price;
    protected String material;
    protected String producer;

    public Furniture() {
        price = 0.0;
        material = new String();
        producer = new String();
    }

    public Furniture(String material) {
        this.material = material;
        furnitureProd();
        price = 0.0;
    }

    public Furniture(String material, double price) {
        this.material = material;
        this.price = price;
        furnitureProd();
    }

    public double getPrice() {
        return price;
    }

    public String getMaterial() {
        return material;
    }

  public abstract String furnitureProd();
}
