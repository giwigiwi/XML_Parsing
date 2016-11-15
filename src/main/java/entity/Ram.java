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

    @Override
    public String toString() {
        return "Ram{" +
                "power=" + power +
                ", clock='" + clock + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ram ram = (Ram) o;

        if (power != ram.power) return false;
        if (clock != null ? !clock.equals(ram.clock) : ram.clock != null) return false;
        if (capacity != null ? !capacity.equals(ram.capacity) : ram.capacity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = power;
        result = 31 * result + (clock != null ? clock.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        return result;
    }
}
