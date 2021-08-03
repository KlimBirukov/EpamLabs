package Xml;

import domain.shelf.Shelf;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ShelfXmlReader {
    public static List<Shelf> readFromFile(String fileName) {
        List<Shelf> currentShelves = new ArrayList<>();
        try {
            InputStream stream = new FileInputStream(fileName);
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(stream);

            int elementShelfName;
            String tagName;

            Shelf newShelf = null;

            while (reader.hasNext()) {
                elementShelfName = reader.next();
                switch (elementShelfName) {
                    case XMLStreamReader.START_ELEMENT: {
                        tagName = reader.getLocalName();
                        switch (tagName) {
                            case "name":
                                newShelf = new Shelf();
                                newShelf.setName(reader.getAttributeValue(null,"id"));
                                break;
                            case "totalWeight":
                                newShelf.setTotalWeight(Integer.parseInt(reader.getElementText()));
                                break;
                            case "amountOfStone":
                                newShelf.setAmountOfStone(Integer.parseInt(reader.getElementText()));
                                break;
                            case "totalPrise":
                                newShelf.setTotalPrise(Integer.parseInt(reader.getElementText()));
                                break;
                        }
                        break;
                    }
                    case XMLStreamReader.END_ELEMENT: {
                        tagName = reader.getLocalName();
                        if ("name".equals(tagName)) {
                            currentShelves.add(newShelf);
                        }
                        break;
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }

        return currentShelves;
    }
}
