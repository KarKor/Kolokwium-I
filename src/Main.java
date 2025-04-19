public class Main {
    public static void main(String[] args){
        //System.out.println("\nHello world");
        //Clock time = new Clock;
        DigitalClock digit1 = new DigitalClock(13, 56, 12,DigitalClock.Format.H12);
        System.out.println(digit1.toString());
        DigitalClock digit2 = new DigitalClock(23, 12, 54,DigitalClock.Format.H24);
        System.out.println(digit2.toString());


    }
}
