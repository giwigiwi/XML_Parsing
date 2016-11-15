import entity.Computer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;
import parser.DomPartsParser;
import parser.SaxPartsParser;
import parser.StaxPartsParser;

import javax.xml.parsers.ParserConfigurationException;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(DomPartsParser.class.getName());

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        Computer comp = SaxPartsParser.parse();
        Computer comp1 = StaxPartsParser.parse();
        Computer comp2 = DomPartsParser.parse();
        if(comp.equals(comp1)|| comp1.equals(comp2)){
          log.info("3 PC from Computer.xml created by 3 parsers are the same");
        }
    }
}
