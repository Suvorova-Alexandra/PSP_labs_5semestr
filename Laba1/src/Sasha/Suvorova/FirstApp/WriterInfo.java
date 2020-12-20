package Sasha.Suvorova.FirstApp;

public class WriterInfo{
public void showEmployees(Employee employee){
        System.out.println("Фамилия работника: "+ employee.getName()
        + ". " + "Зарплата: "+ employee.getSalary()
        + "бел.р. ");
    if(employee.isChildren()){
        System.out.println("Есть дети.");
    }
    else{
        System.out.println("Нет детей.");
    }
        }
}
