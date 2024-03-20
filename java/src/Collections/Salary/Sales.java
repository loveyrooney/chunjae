package Collections.Salary;

public class Sales extends Employee implements Bonus{
    public Sales() {
    }

    public Sales(String name, int number, String department, int salary) {
        super(name, number, department, salary);
    }

    @Override
    public double tax() {
        //세금의 13%
        return super.tax()*0.13;
    }

    @Override
    public void incentive(int pay) {
        //지급액의 120%
        int salary = super.getSalary();
        salary += (int)(pay*1.2);
        super.setSalary(salary);
    }
}
