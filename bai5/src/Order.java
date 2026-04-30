abstract public class Order {
    private double weight;
    private double distance;
    public Order(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }
    protected double getWeight() {
        return weight;
    }

    protected double getDistance() {
        return distance;
    }
    abstract public double getDeliveryFee();
    abstract String getLabel();
    }
    class Fragile extends Order{
        public Fragile(double weight, double distance){
            super(weight,distance);
        }
        public double getDeliveryFee(){
            return this.getWeight() * 5000 + this.getDistance() * 700 + 20000;
        }
        public String getLabel(){
            return "[HÀNG DỄ VỠ]";
        }
    }
    class Standard extends Order{
    public Standard(double weight, double distance){
        super(weight, distance);
    }
    public double getDeliveryFee(){
        return this.getWeight()*3000 + this.getDistance()*500;
    }
        public String getLabel(){
            return "[THƯỜNG]";
        }
    }
    class Express extends Order{
    public Express(double weight, double distance){
        super(weight, distance);
    }
    public double getDeliveryFee(){
        return (this.getWeight()*3000 + this.getDistance()*500)*1.5;
    }
        public String getLabel(){
            return "[HỎA TỐC]";
        }
    }
    class Bulky extends Order{
        Bulky(double weight, double distance){
            super(weight, distance);
        }

        @Override
        public double getDeliveryFee() {
            return  this.getWeight()*400 + getDistance()*600 + 50000;
        }
        public String getLabel(){
            return "[HÀNG CỒNG KỀNH]";
        }
    }
