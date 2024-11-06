package org.learning.record;

public class Driver {
    public static void main(String[] args) {
        Employee employee = new Employee("shenli", 123);
        System.out.println(employee);

        Employee employee2 = new Employee("shenli", -123);
        System.out.println(employee2);
    }
}
