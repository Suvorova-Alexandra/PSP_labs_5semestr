package Laba3;

public class Chair extends Furniture {
    private boolean backControl;

    public Chair() {
        super();
        backControl = false;
    }

    public Chair(boolean backControl, String material) {
        super(material);
        furnitureProd();
        this.backControl = backControl;
    }

    public Chair(boolean backControl, String material, double price) {
        super(material, price);
        furnitureProd();
        this.backControl = backControl;
    }

    public String isBackControl() {
        String str;
        if (backControl) {
            str = "есть.";
        } else {
            str = "Нет";
        }
        return str;
    }

    @Override
    public String furnitureProd() {
        producer = "Альвеола";
        return producer;
    }
}
