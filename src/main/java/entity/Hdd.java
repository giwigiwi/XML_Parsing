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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hdd hdd = (Hdd) o;

        if (power != hdd.power) return false;
        return spindleSpeed != null ? spindleSpeed.equals(hdd.spindleSpeed) : hdd.spindleSpeed == null;

    }

    @Override
    public int hashCode() {
        int result = power;
        result = 31 * result + (spindleSpeed != null ? spindleSpeed.hashCode() : 0);
        return result;
    }
}
