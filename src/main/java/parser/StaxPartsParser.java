package parser;

import entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class StaxPartsParser {
    private static Logger log = LoggerFactory.getLogger(StaxPartsParser.class.getName());
    private static Computer comp1 = new Computer();
    private static boolean isName= false;
    private static Cpu cpu = new Cpu();
    private static Ram ram = new Ram();
    private static Hdd hdd = new Hdd();
    private static VideoCard vCard = new VideoCard();
    private static boolean isCpu = false;
    private static boolean isRam = false;
    private static boolean isHdd = false;
    private static boolean isVCard = false;
    private static boolean isPower;
    private static boolean isClock;
    private static boolean isBits;
    private static boolean isProducer;
    private static boolean isRamSize;
    private static boolean isSpSpeed;
    private static boolean isPowerSupply;
    private static boolean isCapacity;

    public static Computer parse() {
        log.debug("Start StAX-parsing...");
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader =
                    factory.createXMLEventReader(
                            new FileReader( "src/main/resources/Computer.xml"));

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String currentE = startElement.getName().getLocalPart();

                        if (currentE.equalsIgnoreCase("part")) {
                        } else if (currentE.equalsIgnoreCase("name")) {
                            isName = true;
                        } else if (currentE.equalsIgnoreCase("power")) {
                            isPower = true;
                        } else if (currentE.equalsIgnoreCase("clock")) {
                            isClock = true;
                        } else if (currentE.equalsIgnoreCase("bits")) {
                            isBits = true;
                        }else if (currentE.equalsIgnoreCase("producer")) {
                            isProducer = true;
                        }else if (currentE.equalsIgnoreCase("ramsize")) {
                            isRamSize = true;
                        }else if (currentE.equalsIgnoreCase("spindlespeed")) {
                            isSpSpeed = true;
                        }else if (currentE.equalsIgnoreCase("powersupply")) {
                            isPowerSupply = true;
                        }else if (currentE.equalsIgnoreCase("capacity")) {
                            isCapacity = true;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if (isName) {
                            if(characters.getData().equalsIgnoreCase("cpu")) isCpu=true;
                            else if(characters.getData().equalsIgnoreCase("ram")) isRam=true;
                            else if(characters.getData().equalsIgnoreCase("hdd")) isHdd=true;
                            else if(characters.getData().equalsIgnoreCase("videocard")) isVCard =true;
                            isName = false;
                        }
                        if (isPower) {
                            if (isCpu) cpu.setPower(new Integer(characters.getData()));
                            else if (isRam) ram.setPower(new Integer(characters.getData()));
                            else if (isHdd) {
                                hdd.setPower(new Integer(characters.getData()));
                                isHdd = false;
                            } else if (isVCard) {
                                vCard.setPower(new Integer(characters.getData()));
                                isVCard = false;
                            }
                            isPower = false;
                        }
                        if (isClock) {
                            if (isCpu) {
                                cpu.setClock(characters.getData());
                                isCpu = false;
                            } else if (isRam) {
                                ram.setClock(characters.getData());
                            }
                            isClock = false;
                        }
                        if (isBits) {
                            cpu.setBits(characters.getData());
                            isBits=false;
                        }
                        if(isProducer){
                            vCard.setProducer(characters.getData());
                            isProducer=false;
                        }
                        if(isCapacity){
                            ram.setCapacity(characters.getData());
                            isCapacity=false;
                            isRam = false;
                        }
                        if(isRamSize){
                            vCard.setRamSize(characters.getData());
                            isRamSize=false;
                        }
                        if(isSpSpeed){
                            hdd.setSpindleSpeed(characters.getData());
                            isSpSpeed=false;
                        }
                        if(isPowerSupply){
                            comp1.setPowerSupply(new Integer(characters.getData()));
                            isPowerSupply=false;
                        }

                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();
                        if (endElement.getName().getLocalPart().equalsIgnoreCase("partslist")) {
                            comp1.getPartsList().add(cpu);
                            comp1.getPartsList().add(ram);
                            comp1.getPartsList().add(hdd);
                            comp1.getPartsList().add(vCard);
                        }
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        log.debug("Parts List collection in {} include {} parts",Computer.class.getName(),comp1.getPartsList().size());
            log.debug(comp1.getPartsList().toString());
        log.debug("Stop StAX-parsing");
        return comp1;
    }

}
