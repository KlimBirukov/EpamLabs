package Task_1.Xml;

import Task_1.domain.stone.Stone;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

public class StoneXmlWriter {
    public static void WriteToFile(String fileName, List<Stone> stones) {
        try{
            OutputStream stream = new FileOutputStream(fileName);
            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = factory.createXMLStreamWriter(stream);
            writer.writeStartElement("?xml version=\"1.0\" encoding=\"UTF-8\"?");
            writer.writeCharacters("\n");
            writer.writeStartElement("stones");
            writer.writeCharacters("\n");

            for(Stone s: stones){
                writer.writeCharacters("\t");
                writer.writeStartElement("type");
                writer.writeAttribute("id",s.getType());
                writer.writeCharacters("\n");
                writer.writeCharacters("\t\t");

                writer.writeStartElement("personalNumber");
                writer.writeCharacters(s.getPersonalNumber().toString());
                writer.writeEndElement();
                writer.writeCharacters("\n");
                writer.writeCharacters("\t\t");

                writer.writeStartElement("name");
                writer.writeCharacters(s.getName());
                writer.writeEndElement();
                writer.writeCharacters("\n");
                writer.writeCharacters("\t\t");

                writer.writeStartElement("weight");
                writer.writeCharacters(s.getWeight().toString());
                writer.writeEndElement();
                writer.writeCharacters("\n");
                writer.writeCharacters("\t\t");

                writer.writeStartElement("transparency");
                writer.writeCharacters(s.getTransparency().toString());
                writer.writeEndElement();
                writer.writeCharacters("\n");
                writer.writeCharacters("\t\t");

                writer.writeStartElement("prise");
                writer.writeCharacters(s.getPrise().toString());
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
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
