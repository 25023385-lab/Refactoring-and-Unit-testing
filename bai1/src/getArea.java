
//tách các điều kiện, nhánh if, else thành các method riêng => Decompose Conditional và Replace Conditional with Polymorphism
//public double getArea(String shapeType, double a, double b) {
//    if (shapeType.equals("rectangle")) return a * b;
//    if (shapeType.equals("triangle"))  return 0.5 * a * b;
//    if (shapeType.equals("circle"))    return 3.14159 * a * a;
//    return -1;
//}

interface Area{
    public double getArea();
}

class Rectangle implements Area{
    double a;
    double b;
    public double getArea(){
        return 0.5 * a * b;
    }
}
class Circle implements Area{
    double a;
    public double getArea(){
        return 3.14159 * a * a;
    }
}
//code mà cần biết loại gì trước khi chạy thường là lỗi if/switch => polymorphism