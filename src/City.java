import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
}
