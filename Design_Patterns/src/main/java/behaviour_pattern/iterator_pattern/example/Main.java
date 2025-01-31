package behaviour_pattern.iterator_pattern.example;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Ankit");
        Employee employee2 = new Employee("Ram");
        Employee employee3 = new Employee("Sona");

        StaffList staffList = new StaffList(employee1, employee2, employee3);
        StaffListIterator staffListIterator = staffList.iterator();

        while(staffListIterator.hasNext()){
            Employee employee = staffListIterator.next();
            System.out.println(employee.getName());
        }
    }
}
