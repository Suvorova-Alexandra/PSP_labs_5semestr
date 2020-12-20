package Laba3Part2;

public abstract class Chair implements Furniture, Object {
    protected boolean backControl;
    protected String producer;
    protected double price;
    protected String material;

    public Chair(String material, double price, boolean backControl) {
        this.material = material;
        this.price = price;
        this.backControl = backControl;
        furnitureProd();
    }

    @Override
    public abstract String furnitureProd();

    @Override
    public abstract void print();


}
