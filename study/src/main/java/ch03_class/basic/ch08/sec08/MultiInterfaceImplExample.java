package main.java.ch03_class.basic.ch08.sec08;

import ch08.sec08.SmartTelevision;

public class MultiInterfaceImplExample {

    public static void main(String[] args) {

        SmartTelevision rc = new SmartTelevision();
        rc.turnOn();
        rc.turnOff();

        SmartTelevision searchable = new SmartTelevision();
        searchable.search("https://www.youtube.com");

    }

}
