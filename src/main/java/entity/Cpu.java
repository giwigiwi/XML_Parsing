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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cpu cpu = (Cpu) o;

        if (power != cpu.power) return false;
        if (clock != null ? !clock.equals(cpu.clock) : cpu.clock != null) return false;
        return bits != null ? bits.equals(cpu.bits) : cpu.bits == null;

    }

    @Override
    public int hashCode() {
        int result = power;
        result = 31 * result + (clock != null ? clock.hashCode() : 0);
        result = 31 * result + (bits != null ? bits.hashCode() : 0);
        return result;
    }
}
