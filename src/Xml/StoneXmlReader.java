package Xml;

import domain.stone.GemStone;
import domain.stone.SemiGemStone;
import domain.stone.Stone;
import domain.stone.UnknownStone;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StoneXmlReader {
    public static List<Stone> readFromFile(String fileName) {
        List<Stone> currentStones = new ArrayList<>();
        try {
            InputStream stream = new FileInputStream(fileName);
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(stream);

            int elementStoneType;
            String tagStoneType;
            String type;

            UnknownStone newStone = null;

            while (reader.hasNext()) {
                elementStoneType = reader.next();
                switch (elementStoneType) {
                    case XMLStreamReader.START_ELEMENT: {
                        tagStoneType = reader.getLocalName();
                        switch (tagStoneType) {
                            case "type":
                                type = reader.getAttributeValue(null, "id");
                                if (type == "GemStone") {
                                    newStone = new GemStone();
                                } else if (type == "SemiGemStone") {
                                    newStone = new SemiGemStone();
                                } else {
                                    newStone = new UnknownStone();
                                    //You may need to add new types of stones,
                                    //then you can do it here.
                                }
                                newStone.setType(type);
                                break;
                            case "name":
                                newStone.setName(reader.getElementText());
                                break;
                            case "weight":
                                newStone.setWeight(Integer.parseInt(reader.getElementText()));
                                break;
                            case "transparency":
                                newStone.setTransparency(Double.parseDouble(reader.getElementText()));
                                break;
                            case "prise":
                                newStone.setPrise(Integer.parseInt(reader.getElementText()));
                                break;
                        }
                        break;
                    }
                    case XMLStreamReader.END_ELEMENT: {
                        tagStoneType = reader.getLocalName();
                        if ("type".equals(tagStoneType)) {
                            currentStones.add(newStone);
                        }
                        break;
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }

        return currentStones;
    }
}
