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
}
