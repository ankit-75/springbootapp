package behaviour_pattern.iterator_pattern.example;

public class StaffList implements Iterable{

    Employee [] employees;

    public StaffList(Employee ... employees) {
        this.employees = employees;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    @Override
    public StaffListIterator iterator() {
        return new StaffListIterator(this);
    }
}
