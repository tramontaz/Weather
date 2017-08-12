import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        URL url = new URL(" http://api.openweathermap.org/data/2.5/weather?q=Moscow,ru&units=metric&mode=xml&appid=6d0f23a5071298a2af64c8245db45058");
        InputStream inputStream = url.openStream();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputStream);
        final Weather city = Parser.parse(document);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI(city);
            }
        });
    }
}
