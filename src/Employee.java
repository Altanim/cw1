public class Employee {
    private static int idGenerator = 1;
    private String fullName;
    private int department;
    private int id;
    private int salary;

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(String fullName, int department, int salary) {
        this.id = idGenerator++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID" + id + " " + fullName + " Отдел №" + department + "\nЗП: " + salary + "р.\n";
    }
}
