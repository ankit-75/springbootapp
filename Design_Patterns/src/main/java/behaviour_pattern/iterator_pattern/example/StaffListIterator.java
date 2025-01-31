package behaviour_pattern.iterator_pattern.example;

import java.util.Iterator;

public class StaffListIterator implements Iterator {
    StaffList staffList;
    int index;

    public StaffListIterator(StaffList staffList) {
        this.staffList = staffList;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        Employee [] employees = staffList.getEmployees();
        return index < employees.length;
    }

    @Override
    public Employee next() {
        Employee [] employees = staffList.getEmployees();
        if(hasNext()){
            Employee employee = employees[index++];
            return employee;
        }else{
            return null;
        }
    }
}
