package LittleTest;

public class Main {

    public static void main(String[] args) {
        MyTime time1 = new MyTime();
        time1.setTime(22, 59, 3);
        MyTime time2 = new MyTime();
        time2.setTime(23, 59, 59);
        System.out.println(time2.IsHigherThan(time1));
        System.out.println(time1);
        time1.nextSecond();
        System.out.println(time1);
        System.out.println(time2);
        time2.nextSecond();
        System.out.println(time2);
        System.out.println(time2.IsHigherThan(time1));
        System.out.println(time1.getHour() + ":" + time1.getMinute() + ":" + time1.getSecond());

    }
}
