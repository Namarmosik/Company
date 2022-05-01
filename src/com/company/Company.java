package com.company;

import java.util.*;

public class Company {
    private final List<Employee> employees = new ArrayList<>();

    public void hire(Employee employee) {
        this.employees.add(employee);
    }

    public void hireAll(Collection<Employee> employees) {
        this.employees.addAll(employees);
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public static int getIncome() {
        return 15000000;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        return getFilteredLimitedList(count, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return o2.getMonthSalary() - o1.getMonthSalary();
            }
        });
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        return getFilteredLimitedList(count, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return o1.getMonthSalary() - o2.getMonthSalary();
            }
        });
    }

    private List<Employee> getFilteredLimitedList(int count, Comparator<Employee> comparator) {
        List<Employee> copyList = new ArrayList<Employee>(employees);
        Collections.sort(copyList, comparator);
        List<Employee> result = new ArrayList<Employee>();
        for (int i = 0; i < count; i++) {
            result.add(copyList.get(i));
        }
        return result;
    }

    public int countEmployees() {
        return employees.size();
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}