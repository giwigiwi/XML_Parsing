package parser;

import entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DomPartsParser {
    private static Computer comp1 = new Computer();
    private static Cpu cpu = new Cpu();
    private static Ram ram = new Ram();
    private static Hdd hdd = new Hdd();
    private static VideoCard vCard = new VideoCard();

    private static final Logger log = LoggerFactory.getLogger(DomPartsParser.class.getName());
    public static Computer parse () {
        log.debug("Start DOM-parsing...");
        try {
            File inputFile = new File("src/main/resources/Computer.xml");
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Part");
            log.debug("nlist has {} components",nList.getLength());
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if(eElement.getElementsByTagName("name").item(0).getTextContent().equalsIgnoreCase("cpu")){
                        cpu.setPower(new Integer(eElement.getElementsByTagName("power").item(0).getTextContent()));
                        cpu.setClock(eElement.getElementsByTagName("clock").item(0).getTextContent());
                        cpu.setBits(eElement.getElementsByTagName("bits").item(0).getTextContent());
                    }else if (eElement.getElementsByTagName("name").item(0).getTextContent().equalsIgnoreCase("ram")){
                        ram.setPower(new Integer(eElement.getElementsByTagName("power").item(0).getTextContent()));
                        ram.setClock(eElement.getElementsByTagName("clock").item(0).getTextContent());
                        ram.setCapacity(eElement.getElementsByTagName("capacity").item(0).getTextContent());
                    }else if (eElement.getElementsByTagName("name").item(0).getTextContent().equalsIgnoreCase("hdd")){
                        hdd.setPower(new Integer(eElement.getElementsByTagName("power").item(0).getTextContent()));
                        hdd.setSpindleSpeed(eElement.getElementsByTagName("spindleSpeed").item(0).getTextContent());
                    }else if (eElement.getElementsByTagName("name").item(0).getTextContent().equalsIgnoreCase("videocard")){
                        vCard.setPower(new Integer(eElement.getElementsByTagName("power").item(0).getTextContent()));
                        vCard.setProducer(eElement.getElementsByTagName("producer").item(0).getTextContent());
                        vCard.setRamSize(eElement.getElementsByTagName("ramSize").item(0).getTextContent());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        comp1.getPartsList().add(cpu);
        comp1.getPartsList().add(ram);
        comp1.getPartsList().add(hdd);
        comp1.getPartsList().add(vCard);
        log.debug("Parts List collection in {} include {} parts",Computer.class.getName(),comp1.getPartsList().size());
        log.debug(comp1.getPartsList().toString());
        log.debug("Stop DOM-parsing");
        return comp1;
    }

}
