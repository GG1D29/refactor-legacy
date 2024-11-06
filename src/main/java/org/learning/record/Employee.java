package org.learning.record;

public record Employee(String name, int employeeNumber) {
    // This is called Compact Constructor
    public Employee {
        if (employeeNumber < 0) {
            throw new IllegalArgumentException("Employee Number cannot be negative");
        }
    }
}
