package Task_1.Xml;

import Task_1.domain.shelf.Shelf;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

public class ShelfXmlWriter {
    public static void WriteToFile(String fileName, List<Shelf> shelves) {
        try {
            OutputStream stream = new FileOutputStream(fileName);
            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = factory.createXMLStreamWriter(stream);
            writer.writeStartElement("?xml version=\"1.0\" encoding=\"UTF-8\"?");
            writer.writeCharacters("\n");
            writer.writeStartElement("shelves");
            writer.writeCharacters("\n");

            for (Shelf s : shelves) {
                writer.writeCharacters("\t");
                writer.writeStartElement("name");
                writer.writeAttribute("id", s.getName());
                writer.writeCharacters("\n");
                writer.writeCharacters("\t\t");

                writer.writeStartElement("totalWeight");
                writer.writeCharacters(s.getTotalWeight().toString());
                writer.writeEndElement();
                writer.writeCharacters("\n");
                writer.writeCharacters("\t\t");

                writer.writeStartElement("amountOfStone");
                writer.writeCharacters(s.getAmountOfStone().toString());
                writer.writeEndElement();
                writer.writeCharacters("\n");
                writer.writeCharacters("\t\t");

                writer.writeStartElement("totalPrise");
                writer.writeCharacters(s.getTotalPrise().toString());
                writer.writeEndElement();
                writer.writeCharacters("\n");

                writer.writeCharacters("\t");
                writer.writeEndElement();
                writer.writeCharacters("\n");
            }
            writer.writeEndElement();
            writer.writeCharacters("\n");
            writer.writeCharacters("\n");
            writer.flush();
            writer.close();
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
