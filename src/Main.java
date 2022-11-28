public class Main {
    private static final Employee[] EMPLOYEES = new Employee[10];
    private static int indxSalary;
    public static void main(String[] args) {
        EMPLOYEES[0] = new Employee("Сергеев Семен Азаматович",1, 75000);
        EMPLOYEES[1] = new Employee("Устенко Марина Андреевна",1, 78600);
        EMPLOYEES[2] = new Employee("Иванов Никита Семенович",5, 71000);
        EMPLOYEES[3] = new Employee("Петров Михаил Сергеевич",3, 74700);
        EMPLOYEES[4] = new Employee("Никифорова Наталья Николаевна",3, 68000);
        EMPLOYEES[5] = new Employee("Павлова Людмила Андреевна",4, 93000);
        EMPLOYEES[6] = new Employee("Рыбин Евгений Тимурович",2, 74500);
        EMPLOYEES[7] = new Employee("Тимошина Екатерина Сергеевна",2, 86400);
        EMPLOYEES[8] = new Employee("Костюк Семен Андреевич",3, 58900);
        EMPLOYEES[9] = new Employee("Слесарева Ольга Олеговна",5, 98800);

        //БАЗОВАЯ СЛОЖНОСТЬ

        //Получить список всех сотрудников со всеми имеющимися по ним данными
        printEmployees();

        //Посчитать сумму затрат на зарплаты в месяц
        int sumSalaries = sumSalaries();
        System.out.println("Затраты на ЗП составляют: " + sumSalaries + "р.");

        //Найти сотрудника с минимальной зарплатой
        Employee minSalaryEmployee = minSalaryEmployee();
        System.out.println("\nСотрудник с минимальной ЗП: " + minSalaryEmployee);

        //Найти сотрудника с максимальной зарплатой
        Employee maxSalaryEmployee = maxSalaryEmployee();
        System.out.println("\nСотрудник с максимальной ЗП: " + maxSalaryEmployee);

        //Подсчитать среднее значение зарплат
        double averageSalary = averageSalary();
        System.out.println("Средняя зарплата среди сотрудников составляет " + averageSalary + "р.\n");

        //Получить Ф.И.О. всех сотрудников
        getFullName();
        System.out.println();

        //ПОВЫШЕННАЯ СЛОЖНОСТЬ

        //Проиндексировать зарплату
        getIndxSalary(1);
        System.out.println();

        //Найти сотрудника указанного отдела с минимальной зарплатой
        Employee minSalaryEmployeeDep = minSalaryEmployeeDep(3);
        System.out.println("Сотрудник с минимальной зарплатой по указанному отделу:\n" + minSalaryEmployeeDep);

        //Найти сотрудника указанного отдела с максимальной зарплатой
        Employee maxSalaryEmployeeDep = maxSalaryEmployeeDep(3);
        System.out.println("Сотрудник с максимальной зарплатой по указанному отделу:\n" + maxSalaryEmployeeDep);

        //Вычислить сумму зарплат сотрудников указанного отдела
        System.out.println("Затраты на ЗП по указанному отделу составляют: " + sumSalariesDep(1) + "р.");
        System.out.println();

        //Вычислить среднюю сумму зарплат сотрудников указанного отдела
        double averageSalaryDep = averageSalaryDep(1);
        System.out.println("Средняя зарплата среди сотрудников указанного отдела составляет " + averageSalaryDep + "р.");
        System.out.println();

        //Проиндексировать зарплаты сотрудников указанного отдела
        getIndxSalaryDep(1,1);
        System.out.println();

        //Напечатать всех сотрудников указанного отдела
        System.out.println("Сотрудники указанного отдела:");
        getFullNameDep(1);
        System.out.println();

        //Все сотрудники с зарплатой ниже указанного числа
        int lowLevel = 80000;
        System.out.println("Сотрудники с ЗП ниже " + lowLevel + "p.:");
        salaryLowLevel(80000);

        //Все сотрудники с зарплатой выше указанного числа
        int upLevel = 8000;
        System.out.println("\nСотрудники с ЗП выше или равной " + upLevel + "p.:");
        salaryUpLevel(80000);

    }
    private static void printEmployees(){
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }
    private static int sumSalaries(){
        int summ = 0;
        for (Employee employee : EMPLOYEES) {
            summ = summ + employee.getSalary();
        }
        return summ;
    }
    private static Employee minSalaryEmployee() {
        int min = Integer.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (Employee employee : EMPLOYEES) {
            if (employee.getSalary() < min) {
                min = employee.getSalary();
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }
    private static Employee maxSalaryEmployee() {
        int max = Integer.MIN_VALUE;
        Employee maxSalaryEmployee = null;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getSalary() > max) {
                max = employee.getSalary();
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }
    private static double averageSalary(){
        int count = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                count++;
            }
        } if (count != 0){
            return (double) sumSalaries()/count;}
        return 0;
    }
    private static void getFullName () {
        for(Employee employee : EMPLOYEES) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }
    private static void getIndxSalary(int x) {
        for (Employee employee : EMPLOYEES) {
            employee.setSalary(employee.getSalary() + (employee.getSalary()/100*x));
            System.out.println(employee.getFullName() + ", после индексации ЗП составляет " +
                    employee.getSalary() + "р.");
        }
    }
    private static Employee minSalaryEmployeeDep(int depMin) {
        int min = Integer.MAX_VALUE;
        Employee minSalaryEmployeeDep = null;
        for (Employee employee : EMPLOYEES) {
            if (employee.getSalary() < min && employee.getDepartment() == depMin) {
                min = employee.getSalary();
                minSalaryEmployeeDep = employee;
            }
        }
        return minSalaryEmployeeDep;
    }
    private static Employee maxSalaryEmployeeDep(int depMax) {
        int max = Integer.MIN_VALUE;
        Employee maxSalaryEmployeeDep = null;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getSalary() > max && employee.getDepartment() == depMax) {
                max = employee.getSalary();
                maxSalaryEmployeeDep = employee;
            }
        }
        return maxSalaryEmployeeDep;
    }
    private static int sumSalariesDep(int summDep){
        int summ = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == summDep)
                summ = summ + employee.getSalary();
        }
        return summ;
    }
    private static double averageSalaryDep(int averDep){
        int count = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartment() == averDep) {
                count++;
            }
        } if (count != 0){
            return (double) sumSalariesDep(1)/count;}
        return 0;
    }
    private static void getIndxSalaryDep(int percent, int department) {
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == department){
                employee.setSalary(employee.getSalary() + (employee.getSalary()/100*percent));
                System.out.println("ID" + employee.getId() + " " + employee.getFullName() + ", отдел №" + employee.getDepartment() +
                        ", после индексации ЗП составляет " +
                        employee.getSalary() + "р.");}
        }
    }
    private static void getFullNameDep (int depFullName) {
        for(Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartment() == depFullName) {
                System.out.println("ID" + employee.getId() + " " + employee.getFullName() +
                        "\n" + "ЗП " + employee.getSalary() + "р.");
            }
        }
    }
    private static void salaryLowLevel (int lowLevel) {
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getSalary() < lowLevel) {
                System.out.println("ID" + employee.getId() + " " + employee.getFullName() +
                        "\n" + "ЗП " + employee.getSalary() + "р.");
            }
        }
    }
    private static void salaryUpLevel (int UpLevel) {
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getSalary() >= UpLevel) {
                System.out.println("ID" + employee.getId() + " " + employee.getFullName() +
                        "\n" + "ЗП " + employee.getSalary() + "р.");
            }
        }
    }
}