package entity;

public class Hdd implements Part {
    private int power;
    private String spindleSpeed;

    public Hdd() {
    }

    public Hdd(int power, String rotateSpeed) {
        this.power = power;
        this.spindleSpeed = rotateSpeed;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getSpindleSpeed() {
        return spindleSpeed;
    }

    public void setSpindleSpeed(String spindleSpeed) {
        this.spindleSpeed = spindleSpeed;
    }

    @Override
    public String toString() {
        return "Hdd{" +
                "power=" + power +
                ", spindleSpeed='" + spindleSpeed + '\'' +
                '}';
    }
}
