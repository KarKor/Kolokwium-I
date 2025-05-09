import java.time.LocalTime;

public abstract class Clock {

    int hour;
    int minute;
    int second;
    private City city;

    public City getCity() {
        return city;
    }
    
    public void setCurrentTime(){
        hour = LocalTime.now().getHour();
        minute = LocalTime.now().getMinute();
        second = LocalTime.now().getSecond();
    }

    public void setTime(int h, int m, int s) /*throws IllegalArgumentException*/{

        if(!(h>=0 && h<24 && m>=0 && m<60 && s>=0 && s<60)) {
            throw new IllegalArgumentException("Time Values Out of Range");
        }
        this.hour = h;
        this.minute = m;
        this.second = s;

    }

    public Clock(int hour, int minute, int second, City city) {
        setTime(hour, minute, second);
        this.city=city;
    }

    public void setCity(City cityName){
        hour=(hour+(cityName.gettZone()-this.city.gettZone()))%24;
        if(hour<0) hour +=24;
        this.city=cityName;
    }

    @Override
    public String toString() {
        return  hour + ":" + minute +":" + second;
    }
}
