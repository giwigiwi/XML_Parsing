package entity;

public class Cpu implements Part {
    private int power;
    private String clock;
    private String bits;

    public Cpu() {
    }

    public Cpu(int power, String clock, String bits) {
        this.power = power;
        this.clock = clock;
        this.bits = bits;
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

    public String getBits() {
        return bits;
    }

    public void setBits(String bits) {
        this.bits = bits;
    }

    @Override
    public String toString() {
        return "Cpu{" +
                "power=" + power +
                ", clock='" + clock + '\'' +
                ", bits='" + bits + '\'' +
                '}';
    }
}
