package Laba2;

public class Employee {
    private String name;
    private int salary;
    private boolean children;

    public Employee() {
        name = String.valueOf("-");
        children = false;
        salary = 0;
    }

    public Employee(String name, int salary, boolean children) {
        this.name = name;
        this.salary = salary;
        this.children = children;
    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
        this.children = false;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public boolean isChildren() {
        return children;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void isChildren(boolean child) {
        this.children = child;
    }

    public void Print() {
        System.out.println("Фамилия: " + name);
        if (children) {
            System.out.println("Есть дети.");
        } else {
            System.out.println("Нет детей.");
        }
        System.out.println("Зарплата: " + salary + "бел.р.");
    }

    public static int AvgSalary(Employee[] obj) {
        int sum = 0;
        for (int i = 0; i < obj.length; i++) {
            sum = sum + obj[i].getSalary();
        }
        return sum / 4;
    }

    public static int IfChildren(Employee[] obj) {
        int number = 0;
        for (int i = 0; i < obj.length; i++) {
            if (obj[i].isChildren()) {
                number++;
            }
        }
        return number;
    }
}