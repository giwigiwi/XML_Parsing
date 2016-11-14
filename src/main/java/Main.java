import entity.Computer;
import org.xml.sax.SAXException;
import parser.SaxPartsParser;
import parser.StaxPartsParser;

import javax.xml.parsers.ParserConfigurationException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        Computer comp = SaxPartsParser.parse();
        Computer comp1 = StaxPartsParser.parse();
    }
}
