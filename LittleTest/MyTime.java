package LittleTest;


public class MyTime {
    private int hour;
    private int minute;
    private int second;

    public void setTime(int hour, int minute, int second){
        if(hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59 && second >= 0 && second <= 59) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        } else {
            throw new IllegalArgumentException("Invalid hour, minute, or second!");
        }
    }

    public int getHour() {
        return hour;
    }
    public int getMinute() {
        return minute;
    }
    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return hour +
                ":" + minute +
                ":" + second;
    }

    public void nextSecond() {
        if(second < 59){
            this.second += 1;
        } else if(minute < 59){
            this.minute += 1;
            this.second = 0;
        } else if(hour < 23) {
            this.hour += 1;
            this.second = 0;
            this.minute = 0;
        } else {
            this.hour = 0;
            this.second = 0;
            this.minute = 0;
        }
    }

    public boolean IsHigherThan(MyTime time) {
        if (time.getHour() < this.getHour()) {
            return true;
        }
        if (time.getHour() == this.getHour()) {
            if (time.getMinute() < this.getMinute()) {
                return true;
            }
            if (time.getMinute() == this.getMinute()) {
                if (time.getSecond() < this.getSecond()) {
                    return true;
                }
            }
        }
        return false;
    }
}
