package com.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamOperations {
	
	public static void main(String[] args) {
		
		//Define an Employee Collection object
		List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "Alice Smith", "HR", 2019, 50000.0, "Female"));
        employees.add(new Employee(102, "Bob Johnson", "IT", 2020, 60000.0, "Male"));
        employees.add(new Employee(103, "Charlie Brown", "Finance", 2018, 55000.0, "Male"));
        employees.add(new Employee(104, "Diana Prince", "Marketing", 2021, 62000.0, "Female"));
        employees.add(new Employee(105, "Ethan Hunt", "IT", 2017, 75000.0, "Male"));
        employees.add(new Employee(106, "Fiona Apple", "HR", 2020, 48000.0, "Female"));
        employees.add(new Employee(107, "George Lucas", "Finance", 2022, 53000.0, "Male"));
        employees.add(new Employee(108, "Hannah Montana", "Marketing", 2019, 58000.0, "Female"));
        employees.add(new Employee(109, "Ian Fleming", "IT", 2018, 67000.0, "Male"));
        employees.add(new Employee(110, "Julia Roberts", "HR", 2016, 59000.0, "Female"));
        employees.add(new Employee(111, "Kevin Spacey", "Finance", 2021, 72000.0, "Male"));
        employees.add(new Employee(112, "Laura Croft", "Marketing", 2015, 61000.0, "Female"));
        employees.add(new Employee(113, "Michael Scott", "IT", 2022, 64000.0, "Male"));
        employees.add(new Employee(114, "Nina Dobrev", "Finance", 2020, 56000.0, "Female"));
        employees.add(new Employee(115, "Oscar Isaac", "Marketing", 2019, 67000.0, "Male"));

        
        //Filtered based on department
        Map<String, List<Employee>> filteredWithDept = employees.stream().collect(Collectors.groupingBy(i->i.getDept()));
        
        System.out.println("===Filtered with department===");
        
        for (Map.Entry<String, List<Employee>> entry : filteredWithDept.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        //Filter based on gender
        
        Map<String, List<Employee>> genderBasedFilter = employees.stream().collect(Collectors.groupingBy(i->i.getGender()));
        
        System.out.println("===Gender based filter====");
        
        for(Map.Entry<String,List<Employee>> entry:genderBasedFilter.entrySet()) {
        	System.out.println(entry.getKey()+" "+entry.getValue());
        }
        
        
        //Total Female employees in an organization
        Long femaleCountInOrg = employees.stream().filter(i->i.getGender().equals("Female")).collect(Collectors.counting());
        
        System.out.println("===Female count in an organization===");
        System.out.println("Total female employees in organization::"+femaleCountInOrg);
	
	   
        System.out.println("====Male count in an organization===");
        
        Long maleCount=employees.stream().filter(i->i.getGender().equals("Male")).collect(Collectors.counting());
	
	   System.out.println("Total Males in an organization::"+maleCount);
	   
	   
	   System.out.println("===Average salary of employees in a Finance department===");
	   
	   Double financeAverageSalary = employees.stream().filter(i->i.getDept().equals("Finance")).collect(Collectors.averagingDouble(Employee::getSalary));
	
	   System.out.println("Average salary of employees in Finance::"+financeAverageSalary);
	
	   
	   System.out.println("===Employees joined after 2018===");
	   
	   List<Employee> joinedAfterEmployee=employees.stream().filter(i->i.getJoinedYear()>2018).collect(Collectors.toList());
	   
	   System.out.println("===Employees joined after 2018===");
	   joinedAfterEmployee.forEach(System.out::println);
	   
	   System.out.println("===Employees joined before 2018===");
	   List<Employee> joinedBefore=employees.stream().filter(i->i.getJoinedYear()<=2018).collect(Collectors.toList());
	
	   joinedBefore.forEach(System.out::println);
	
	   System.out.println();
	   System.out.println();
	 
	   System.out.println("===Sorting Based on Salary in descending order===");
	   
	   List<Employee> sortedSalaryDescending=employees.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList()).reversed();
	   
	   sortedSalaryDescending.forEach(System.out::println);
	   
	   System.out.println("===Sorting Based on Salary in ascending order===");
	
	   List<Employee> sortedSalaryAscending=employees.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
	   
	   sortedSalaryAscending.forEach(System.out::println);
	
	 //Grouping Employees by department
	   System.out.println("===Grouping Employees by department===");
	 Map<String,List<Employee>> empGroupedOnDeoartmentWise=employees.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.toList()));
	   
	 for(Map.Entry<String,List<Employee>> entry: empGroupedOnDeoartmentWise.entrySet()) {
		 
		 System.out.println(entry.getKey()+" "+entry.getValue());
	 }
	 
	 
	 System.out.println("===Employee names to uppercase===");
	 List<String> empNameUppercase=employees.stream().map(i->i.getEmpName().toUpperCase()).collect(Collectors.toList());
	
	 empNameUppercase.forEach(System.out::println);
	 
	 System.out.println();
	 System.out.println();
	 System.out.println("===Salary greater than 60000");
	 List<Employee> salaryGreater=employees.stream().filter(i->i.getSalary()>=60000).collect(Collectors.toList());
	
	 salaryGreater.forEach(System.out::println);
	
	System.out.println();
	System.out.println();
	
	System.out.println("===Employee with highest salary===");
	Employee highestSalary=employees.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList()).getFirst();
	
	System.out.println(highestSalary);
	
	
	
	}

}
