package Collections.Salary;

public class Secretary extends Employee implements Bonus{
    public Secretary() {
    }

    public Secretary(String name, int number, String department, int salary) {
        super(name, number, department, salary);
    }

    @Override
    public double tax() {
        //세금의 10%
        return super.tax()*0.1;
    }

    @Override
    public void incentive(int pay) {
        //지급액의 80%
        int salary = super.getSalary();
        salary += (int)(pay*0.8);
        super.setSalary(salary);
    }
}
