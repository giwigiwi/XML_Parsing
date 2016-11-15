package entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Computer {
    private static Logger log = LoggerFactory.getLogger(Computer.class.getName());
    private ArrayList<Part> partsList = new ArrayList<>();
    private int powerSupply;

    public Computer() {
    }

    public Computer(ArrayList partsList, int powerSupply) {
        this.partsList = partsList;
        this.powerSupply = powerSupply;
        log.info("Your PC was successful assembling");
    }
    public ArrayList<Part> getPartsList() {
        return partsList;
    }

    public int getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(int powerSupply) {
        this.powerSupply = powerSupply;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Computer computer = (Computer) o;

        if (powerSupply != computer.powerSupply) return false;
        return partsList != null ? partsList.equals(computer.partsList) : computer.partsList == null;

    }

    @Override
    public int hashCode() {
        int result = partsList != null ? partsList.hashCode() : 0;
        result = 31 * result + powerSupply;
        return result;
    }
}
