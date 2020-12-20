package MainPackage;

import Laba2.Employee;

public class Main {
    public static void main(String args[]) {
        Employee[] e1 = new Employee[4];
        e1[0] = new Employee();
        e1[1] = new Employee("Иванов", 2000, true);
        e1[2] = new Employee("Сидоров", 1500);
        e1[3] = new Employee("Петров", 4000, true);
        for (int i = 0; i < 4; i++) {
            System.out.println(i + 1 + ".Работник");
            e1[i].Print();
        }
        System.out.println("Средняя зарплата работников:" + Employee.AvgSalary(e1));
        System.out.println("Количество работников с детьми:" + Employee.IfChildren(e1));

    }
}
