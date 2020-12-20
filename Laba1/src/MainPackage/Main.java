package MainPackage;

import Sasha.Suvorova.FirstApp.WriterInfo;
import Sasha.Suvorova.FirstApp.Employee;

public class Main {
        public static void main(String args[]){
            Employee obj1=new Employee();
            Employee obj2=new Employee("Иванов",2000,true);
            Employee obj3=new Employee("Сидоров",1500);
            Employee obj4=new Employee();
            obj4.setName("Петров");
            obj4.setSalary(4000);

            WriterInfo object=new WriterInfo();

            object.showEmployees(obj2);
            object.showEmployees(obj1);
            object.showEmployees(obj3);
            object.showEmployees(obj4);
        }
}
