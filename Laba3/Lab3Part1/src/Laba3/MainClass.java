package Laba3;

public class MainClass {
    public static void main(String[] args) {

        Bookcase book1 = new Bookcase("Сосна", 147, 250, 30, 55);
        Table table1 = new Table("Осина", 140.9, 4, 30);
        Chair chair1 = new Chair(true, "Ольха", 2400.6);
        WriterInfo print = new WriterInfo();
        print.showBookcase(book1);
        print.showChair(chair1);
        print.showTable(table1);
    }
}
