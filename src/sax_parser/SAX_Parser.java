package sax_parser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class SAX_Parser {

    public static void main(String[] args) {
        String nomFich = "clientes.xml";
        try {
//          XMLReader parserSAX = XMLReaderFactory.createXMLReader(); XMLReaderFactory is deprecated since java version 9
        	SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            parserFactory.setNamespaceAware(true);
            SAXParser parser = parserFactory.newSAXParser();
            XMLReader parserSAX = parser.getXMLReader();

            GestorEventos gestorEventos = new GestorEventos(System.out);
            parserSAX.setContentHandler(gestorEventos);
            parserSAX.parse(nomFich);
        } catch (SAXException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
