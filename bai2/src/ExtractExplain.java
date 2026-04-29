public class ExtractExplain {
    private static final double SOCIAL_INSURANCE_RATE = 0.08;
    private static final double HEALTH_INSURANCE_RATE = 0.015;
    private static final double PERSONAL_DEDUCTION = 11_000_000;
    private static final double TAX_BRACKET_1_LIMIT = 5_000_000;
    private static final double TAX_BRACKET_2_LIMIT = 10_000_000;
    private static final double TAX_RATE_LEVEL_1 = 0.05;
    private static final double TAX_RATE_LEVEL_2 = 0.10;
    private static final double TAX_BASE_LEVEL_2 = 250_000;
    private static final double TAX_BASE_LEVEL_3 = 750_000;
    public double salaryCaculate(double baseSalary,int workDays, int totalDays){
        return baseSalary * workDays / totalDays;
    }
    public double insuranceCaculate(double actualSalary){
        return actualSalary * (SOCIAL_INSURANCE_RATE + HEALTH_INSURANCE_RATE);
    }
    public double calculateTax(double actualSalary, double insurance, double highestTaxRate){
        double taxableIncome = actualSalary - insurance - PERSONAL_DEDUCTION;
        if (taxableIncome <= 0) {
            return 0;
        }
        if (taxableIncome <= TAX_BRACKET_1_LIMIT) {
            return taxableIncome * TAX_RATE_LEVEL_1;
        }
        if (taxableIncome <= TAX_BRACKET_2_LIMIT) {
            return TAX_BASE_LEVEL_2 + (taxableIncome - TAX_BRACKET_1_LIMIT) * TAX_RATE_LEVEL_2;
        }

        return TAX_BASE_LEVEL_3 + (taxableIncome - TAX_BRACKET_2_LIMIT) * highestTaxRate;
    }
    private double calculateNetSalary(double actualSalary, double insurance, double tax, double bonus) {
        return actualSalary - insurance - tax + bonus;
    }
    public void printPayrollNew(String name, double baseSalary, int workDays, int totalDays, double taxRate, double bonus) {
        // 1. Gọi các phương thức con để xử lý logic tính toán
        double actualSalary = salaryCaculate(baseSalary, workDays, totalDays);
        double insurance = insuranceCaculate(actualSalary);
        double tax = calculateTax(actualSalary, insurance, taxRate);
        double netSalary = calculateNetSalary(actualSalary, insurance, tax, bonus);

        // 2. Chỉ tập trung vào nhiệm vụ in ấn (Printing)
        System.out.println("=== BẢNG LƯƠNG (SAU REFACTOR) ===");
        System.out.println("Nhân viên: " + name);
        System.out.println("Lương cơ bản: " + baseSalary);
        System.out.println("Ngày công: " + workDays + "/" + totalDays);
        System.out.println("Lương thực tế: " + actualSalary);
        System.out.println("Bảo hiểm: " + insurance);
        System.out.println("Thuế TNCN: " + tax);
        System.out.println("Thưởng: " + bonus);
        System.out.println("Thực nhận: " + netSalary);
        System.out.println();
    }
}
class Main{
    public static void main(String[] args) {
        ExtractExplain payroll = new ExtractExplain();

        // Dữ liệu mẫu: Lương 30tr, làm đủ 22/22 ngày, thuế suất vượt ngưỡng 15%, thưởng 5tr
        String name = "Nguyễn Văn A";
        double baseSalary = 30_000_000;
        int workDays = 22;
        int totalDays = 22;
        double taxRate = 0.15;
        double bonus = 5_000_000;

    }
}