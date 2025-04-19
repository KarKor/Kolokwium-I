public class DigitalClock extends Clock{
    public enum Format{
        H24,
        H12
    }
    private Format format;

    public DigitalClock (int hour, int minute, int second, City city, Format format)
    {
        super(hour, minute, second, city);
        this.format=format;
    }


//    public DigitalClock(Format format) {
//        this.format = format;
//    }
    @Override
    public String toString() {

        if (format == Format.H12) {
                int dhour = hour%12;
                if(dhour==0) dhour=12;
                String ampm = (hour>=12) ? "PM" : "AM";
                return dhour + ":" + minute +":" +second +" " +ampm;

        }
        else{
            return super.toString();
        }
    }

}
