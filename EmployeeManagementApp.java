import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    int age;
    String department;
    String code;
    double salaryRate;

    public Employee(int id, String name, int age, String department, String code, double salaryRate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.code = code;
        this.salaryRate = salaryRate;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", department=" + department + ", code=" + code
                + ", salaryRate=" + salaryRate + "]";
    }
}

public class EmployeeManagementApp {
    static List<Employee> employees = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Khởi tạo 10 nhân viên
        employees.add(new Employee(1, "Nguyen Thuy Diu", 30, "IT", "IT001", 5000.0));
        employees.add(new Employee(2, "Khong Thi Van", 35, "Finance", "FIN002", 6000.0));
        employees.add(new Employee(3, "Nguyen Van Nam", 28, "Marketing", "MKT003", 4500.0));
        employees.add(new Employee(4, "Le Thi Vui", 42, "HR", "HR004", 7000.0));
        employees.add(new Employee(5, "Nguyen Nhat Anh", 31, "IT", "IT005", 5500.0));
        employees.add(new Employee(6, "Le Thuy Dung", 27, "Finance", "FIN006", 4800.0));
        employees.add(new Employee(7, "Nguyen Hong Anh", 39, "Marketing", "MKT007", 6200.0));
        employees.add(new Employee(8, "Nguyen Quang Vinh", 33, "HR", "HR008", 6500.0));
        employees.add(new Employee(9, "Nguyen Van Duy", 26, "IT", "IT009", 4700.0));
        employees.add(new Employee(10, "Le Van Cong", 29, "Finance", "FIN010", 5200.0));

        // Hiển thị danh sách nhân viên
        displayEmployees();

        while (true) {
            System.out.println("\nChon chuc nang:");
            System.out.println("1. Them nhan vien moi");
            System.out.println("2. Xoa nhan vien");
            System.out.println("0. Thoat");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    removeEmployee();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }

    static void displayEmployees() {
        System.out.println("\nDanh sach nhan vien:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    static void addEmployee() {
        System.out.print("Nhap id: ");int id = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng mới

        System.out.print("Nhap ten: ");
        String name = scanner.nextLine();

        System.out.print("Nhap tuoi: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng mới

        System.out.print("Nhap phong ban: ");
        String department = scanner.nextLine();

        System.out.print("Nhap ma nhan vien: ");
        String code = scanner.nextLine();

        System.out.print("Nhap luong: ");
        double salaryRate = scanner.nextDouble();

        Employee newEmployee = new Employee(id, name, age, department, code, salaryRate);
        employees.add(newEmployee);
        System.out.println("Them nhan vien thanh cong.");
        displayEmployees();
    }

    static void removeEmployee() {
        System.out.print("Nhap id nhan vien can xoa: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng mới

        boolean found = false;
        for (Employee employee : employees) {
            if (employee.id == id) {
                employees.remove(employee);
                found = true;
                System.out.println("Xoa nhan vien thanh cong.");
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay nhan vien voi id " + id);
        }

        displayEmployees();
    }
}
