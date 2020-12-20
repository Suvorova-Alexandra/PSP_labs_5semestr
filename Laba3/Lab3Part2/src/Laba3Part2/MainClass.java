package Laba3Part2;

public class MainClass {
    public static void main(String[] args) {
        BarStool bs = new BarStool("береза", 174.9, true);
        Bookcase book1 = new Bookcase(250, 300, "Сосна");
        Table table1 = new Table("Осина", 140.9, 4, 30);
        bs.print();
        table1.print();
        book1.print();

    }
}
