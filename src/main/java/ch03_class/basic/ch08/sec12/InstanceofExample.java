package main.java.ch03_class.basic.ch08.sec12;

public class InstanceofExample {
    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        Bus bus = new Bus();



        ride(taxi);
        System.out.println();
        ride(bus);
    }

    private static void ride(Vehicle v) {
        v.run();
        if (v instanceof Bus){
//            Bus.checkFare();
        }
    }
}
