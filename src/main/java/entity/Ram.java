package entity;

public class Ram implements Part{
    private int power;
    private String clock;
    private String capacity;

    public Ram() {
    }

    public Ram(int power, String clock, String capacity) {
        this.power = power;
        this.clock = clock;
        this.capacity = capacity;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}
