public class Employee {
    // Thuộc tính (fields)
    private int id;
    private String name;
    private double salary;
    
    /**
     * Constructor có tham số
     * @param id Mã nhân viên
     * @param name Tên nhân viên
     * @param salary Lương nhân viên
     */
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    /**
     * Constructor không tham số (optional)
     */
    public Employee() {
    }
    
    // ========== GETTER METHODS ==========
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public double getSalary() {
        return salary;
    }
    
    // ========== SETTER METHODS ==========
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    /**
     * Override phương thức toString để hiển thị thông tin nhân viên
     */
    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', salary=%.1f}", 
                            id, name, salary);
    }
    
    /**
     * Phương thức kiểm tra lương có cao không (optional)
     */
    public boolean isHighSalary() {
        return salary > 1000;
    }
}