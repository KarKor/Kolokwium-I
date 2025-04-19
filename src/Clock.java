import java.time.LocalDateTime;

public abstract class Clock {

    int hour;
    int minute;
    int second;
    //Time currentTime = new Time();
    public void setCurrentTime(){
        hour = LocalDateTime.now().getHour();
        minute = LocalDateTime.now().getMinute();
        second = LocalDateTime.now().getSecond();
    }


    public void setTime(int h, int m, int s) throws IllegalArgumentException{

            hour = h;
            minute = m;
            second = s;
        if(!(h>0 && h<24 && m>0 && m<60 && s>0 && s<60)) {
            throw new IllegalArgumentException("Time Values Out of Range");
        }
    }

    @Override
    public String toString() {
        return  hour + ":" + minute +":" + second;
    }
}
