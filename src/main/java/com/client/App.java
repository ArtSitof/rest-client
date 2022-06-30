package com.client;

import com.client.configuration.MyConfig;
import com.client.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class App 
{
    public static void main( String[] args ) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication"
                , Communication.class);


    }
    // Get all employees
    public static List<Employee> getAllEmployees(Communication communication) {

    List<Employee> allEmployees = communication.getAllEmployees();

    System.out.println(allEmployees);

    return allEmployees;
}

    // Get employee by ID
    public static Employee getEmployee(Communication communication, int id) {
        Employee empById = communication.getEmployee(id);
        System.out.println(empById);

        return empById;
    }

    //Edite employee
    public static void getEmployee(Communication communication, Employee emp, int id) {

        emp.setId(id);

        communication.saveEmployees(emp);
    }

    // Delete employee by ID
    public static void deleteEmployee (Communication communication, int id) {
        communication.deleteEmployees(id);
    }


}
