import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.out.println("\nHello world");
        //Clock time = new Clock;



        Map<String, City> map = new HashMap<>();
        map=City.parseFile("strefy.csv");
        System.out.println(map);

        City warszawa = map.get("Warszawa");
        City kijow = map.get("Kijów");

        DigitalClock digit1 = new DigitalClock(13, 56, 12, warszawa,DigitalClock.Format.H12);
        System.out.println(digit1.toString());
        digit1.setCity(kijow);
        System.out.println(digit1.toString());

        AnalogClock.toSvg("file.svg");
    }
}
