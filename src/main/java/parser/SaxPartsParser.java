package parser;

import entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;


public class SaxPartsParser extends DefaultHandler {
    private static Logger log = LoggerFactory.getLogger(SaxPartsParser.class.getName());
    private static Computer comp1 = new Computer();
    private Cpu cpu = new Cpu();
    private Ram ram = new Ram();
    private Hdd hdd = new Hdd();
    private VideoCard vCard = new VideoCard();
    private String currentE = "";
    private boolean isCpu = false;
    private boolean isRam = false;
    private boolean isHdd = false;
    private boolean isVCard = false;

    public SaxPartsParser() {
    }

    public static Computer parse() throws SAXException, ParserConfigurationException {
        log.debug("Start Sax parsing...");
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SaxPartsParser saxp = new SaxPartsParser();
            parser.parse(new File("src/main/resources/Computer.xml"), saxp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return comp1;
    }


    public void startDocument() throws SAXException {
        log.debug("document was started");
    }

    public void endDocument() throws SAXException {
        log.debug("Document was ended");
        log.debug("{} object was created", Computer.class.getName());
        comp1.getPartsList().add(cpu);
        comp1.getPartsList().add(ram);
        comp1.getPartsList().add(hdd);
        comp1.getPartsList().add(vCard);
        log.debug("Parts List collection in {} include {} parts",Computer.class.getName(),comp1.getPartsList().size());
        log.debug(comp1.getPartsList().toString());
        log.debug("Stop SAX parsing");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentE = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentE = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        switch (currentE) {
            case "PartsList":
                log.debug("parts list was found");
                break;
            case "name":
                if (new String(ch, start, length).equals("Cpu")) isCpu = true;
                else if (new String(ch, start, length).equals("Ram")) isRam = true;
                else if (new String(ch, start, length).equals("Hdd")) isHdd = true;
                else if (new String(ch, start, length).equals("Cpu")) isVCard = true;
                break;
            case "power":
                if (isCpu) cpu.setPower(new Integer(new String(ch, start, length)));
                else if (isRam) ram.setPower(new Integer(new String(ch, start, length)));
                else if (isHdd) {
                    hdd.setPower(new Integer(new String(ch, start, length)));
                    isHdd = false;
                } else if (isVCard) {
                    vCard.setPower(new Integer(new String(ch, start, length)));
                    isVCard = false;
                }
                break;
            case "bits":
                cpu.setBits(new String(ch, start, length));
            case "clock":
                if (isCpu) {
                    cpu.setClock(new String(ch, start, length));
                    isCpu = false;
                } else if (isRam) {
                    ram.setClock(new String(ch, start, length));
                    isRam = false;
                }
                break;
            case "produser":
                vCard.setProducer(new String(ch, start, length));
                break;
            case "capacity":
                ram.setCapacity(new String(ch, start, length));
                break;
            case "ramSize":
                vCard.setRamSize(new String(ch, start, length));
                break;
            case "spindleSpeed":
                hdd.setSpindleSpeed(new String(ch, start, length));
                break;
            case "powerSupply":
                comp1.setPowerSupply(new Integer(new String(ch, start, length)));
        }
        }

}
