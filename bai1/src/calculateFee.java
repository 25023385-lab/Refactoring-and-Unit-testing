//public double calculateFee(String t, int h, double r, boolean m) {
//    double f = h * r;
//    if (m) f = f * 0.9;
//    return f;
//}
// quá nhiều tham số; người đọc phải đoán và suy nghĩ về tham số; tham số t không được dùng; 0.9 nghĩa là gì?
// cần refactor bằng rename method và extract variable (viết rõ tên) và Replace Magic Number with Constant
//rename method dùng khi method name k show dc intention

public class calculateFee{
    static double memberDiscount = 0.9;
    // constant giải thích ý nghĩa của số và có thể hiểu được bởi người
    public double calculateTotalFee(int hour, double rate, boolean isMember){
        //rename các parameter
        double fee = hour * rate;
        // extrac variable:
        if (isMember){
            return fee*memberDiscount;
        }
        return fee;
    }
}
// tham số nào phải đoán/ dữ liệu thật hay điều khiển; biểu thức tên trung gian?