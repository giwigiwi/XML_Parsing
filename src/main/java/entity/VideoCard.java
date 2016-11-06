package entity;

public class VideoCard implements Part{
    private int power;
    private String producer;
    private String ramSize;

    public VideoCard() {
    }

    public VideoCard(int power, String producer, String ramSize) {
        this.power = power;
        this.producer = producer;
        this.ramSize = ramSize;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getRamSize() {
        return ramSize;
    }

    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }
}
