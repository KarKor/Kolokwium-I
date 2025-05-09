import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.*;

import static java.time.LocalTime.NOON;

public class City {
    private String capital;
    private int tZone;
    private String latitude;
    private String longitude;

    public City(String capital, int tZone, String latitude, String longitude) {
        this.capital = capital;
        this.tZone = tZone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCapital() {
        return capital;
    }

    public int gettZone() {
        return tZone;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }


    private static City parseLine(String fStr) {
        String[] parts = fStr.split(",");

        String capital = parts[0].trim();
        int tZone = Integer.parseInt(parts[1].trim());
        String latitude = parts[2].trim();
        String longitude = parts[3].trim();

        return new City(capital, tZone, latitude, longitude);
    }



    public static Map<String, City> parseFile(String fPath){
        Map<String, City> map = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fPath))){
            String line;
            boolean isFirstLine = true;

            while((line=reader.readLine())!=null){
                if(isFirstLine){
                    isFirstLine = false;
                    continue;
                }
                City city = parseLine(line);
                map.put(city.getCapital(), city);

            }
        }catch (IOException e) {
            System.err.println("Error reading file" + e.getMessage());
        }

        return map;

    }

    private double longitudeToDegrees(String longi){
        longi=longi.trim();
        String[] parts = longi.split(" ");
        double degs = Double.parseDouble(parts[0]);
        if(Objects.equals(parts[1], "W")){
            degs=(-1)*degs;
        }

        return degs;
    }
    public LocalTime localMeanTime(LocalTime timeInZone){
        double longitudeDegrees=longitudeToDegrees(this.longitude);
        int offset = (int) Math.round(longitudeDegrees*240);

        return timeInZone.plusSeconds(offset);
    }
    public long offsetInSecs(){
        int zoneSecs = 3600*12 + 3600*tZone;
        int localSecs = localMeanTime(NOON).toSecondOfDay();

        return Math.abs(zoneSecs - localSecs);
    }

    public static Comparator<City> worstTimeZoneFit(){
        return Comparator.comparingLong(City::offsetInSecs).reversed();
    }

}
