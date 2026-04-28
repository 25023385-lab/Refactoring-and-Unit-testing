public class ExtractExplain {
    String name;
    double baseSalary;
    int workDays;
    int totalDays;
    double taxRate;
    double bonus;
    public ExtractExplain(String name, double baseSalary,
                          int workDays, int totalDays,
                          double taxRate, double bonus ){
        this.name = name;
        this.baseSalary = baseSalary;
        this.workDays = workDays;
        this.totalDays = totalDays;
        this.taxRate = taxRate;
        this.bonus = bonus;
    }

    public void actualSalary(){
        double actualSalary = baseSalary * workDays / totalDays;
        System.out.println("Salary: " + actualSalary);
    }
    public void insurance() {
        double insurance = actualSalary * 0.08 + actualSalary * 0.015;

    }
    public void tax(){

    }
}
