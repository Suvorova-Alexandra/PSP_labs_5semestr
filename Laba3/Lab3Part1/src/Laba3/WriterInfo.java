package Laba3;

public class WriterInfo {
    public void showBookcase(Bookcase bookcase) {
        System.out.println("Шкаф. Материал: " + bookcase.material + ". Производитель: " + bookcase.producer + ". Цена: " + bookcase.price +
                "бел.р. Размер: " + bookcase.getWidth() + "x" + bookcase.getHeight() + "x" + bookcase.getDepth() + "см.");

    }

    public void showTable(Table table) {
        System.out.println("Стол. Материал: " + table.material + ". Производитель: " + table.producer + ". Цена: " + table.price +
                "бел.р. Количество ящиков: " + table.getNumBox() + ". Площадь рабочей поверхности: " + table.getSqWorkArea() + " кв.см.");

    }

    public void showChair(Chair chair) {
        System.out.println("Стул. Материал: " + chair.material + ". Производитель: " + chair.producer + ". Цена: " + chair.price +
                "бел.р. Регулировка положения спинки: " + chair.isBackControl());

    }
}
