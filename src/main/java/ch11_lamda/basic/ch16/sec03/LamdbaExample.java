package main.java.ch11_lamda.basic.ch16.sec03;

public class LamdbaExample {
    public static void main(String[] args) {

        Person person = new Person();

        //매개변수가 두 개일 경우
        person.action1((name, job) ->
                System.out.println(name + "이" + job + "을 합니다.")

        );
        person.action1((name, job) -> {
            System.out.printf("%s이 %s을 하지 않습니다.", name, job);
            System.out.println();
        });

        //매개변수가 한 개일 경우
        person.action2((content) -> {
            System.out.printf("\" %s \"라고 말합니다.", content);
            System.out.println();
        });
        person.action2((content) -> {
            System.out.printf("\" %s \"라고 외칩니다.", content);
            System.out.println();
        });
    }
}