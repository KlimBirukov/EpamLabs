package Main;

import TableModal.ShelvesTableModel;
import TableModal.StonesTableModel;
import domain.shelf.Shelf;
import domain.stone.Stone;
import Xml.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String FILE_STONES_NAME = "src/DataBase/StoneBase.xml";
        String FILE_SHELVES_NAME = "src/DataBase/ShelfBase.xml";

        JFrame jFrame = new JFrame("Stones");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(100, 100, 900, 600);
        jFrame.setLayout(null);

        JButton infoButton = new JButton("Show");
        infoButton.setBounds(10, 10, 200, 30);
        jFrame.add(infoButton);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(10, 50, 200, 30);
        jFrame.add(saveButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(220, 50, 200, 30);
        jFrame.add(deleteButton);

        JButton addNewDepartment = new JButton("Add Stones");
        addNewDepartment.setBounds(430, 50, 200, 30);
        jFrame.add(addNewDepartment);

        List<Stone> stones = StoneXmlReader.readFromFile(FILE_STONES_NAME);
        List<Shelf> shelves = ShelfXmlReader.readFromFile(FILE_SHELVES_NAME);

        JComboBox jComboBox = new JComboBox();
        for (Shelf s : shelves) {
            jComboBox.addItem(s.getName());
        }
        jComboBox.setBounds(220, 10, 100, 30);
        jFrame.add(jComboBox);

        JPanel panelForShelves = new JPanel(new BorderLayout());
        panelForShelves.setBounds(25, 140, 850, 100);
        panelForShelves.setBackground(Color.WHITE);
        jFrame.add(panelForShelves);

        JPanel panelForStones = new JPanel(new BorderLayout());
        panelForStones.setBounds(25, 250, 850, 200);
        panelForStones.setBackground(Color.WHITE);
        jFrame.add(panelForStones);

        List<Stone> SelectedStones = new ArrayList<>();
        List<Shelf> SelectedShelves = new ArrayList<>();

        infoButton.addActionListener(info -> {
            jFrame.revalidate();
            panelForShelves.removeAll();
            panelForStones.removeAll();
            SelectedShelves.removeAll(shelves);
            SelectedStones.removeAll(stones);
            String str = (String) jComboBox.getSelectedItem();

            for (Shelf s : shelves) {
                assert str != null;
                if (str.compareToIgnoreCase(s.getName()) == 0) {
                    SelectedShelves.add(s);
                }
            }

            for (Stone s : stones) {
                assert str != null;
                if (str.compareToIgnoreCase(s.getType()) == 0) {
                    SelectedStones.add(s);
                }
            }

            ShelvesTableModel ShelvesModel = new ShelvesTableModel(SelectedShelves);
            JTable ShelvesTable = new JTable(ShelvesModel);
            JScrollPane ShelvesScrollPane = new JScrollPane(ShelvesTable);
            panelForShelves.add(ShelvesScrollPane, BorderLayout.NORTH);

            StonesTableModel StonesModel = new StonesTableModel(SelectedStones);
            JTable StonesTable = new JTable(StonesModel);
            JScrollPane StonesScrollPane = new JScrollPane(StonesTable);
            panelForStones.add(StonesScrollPane, BorderLayout.NORTH);

            jFrame.revalidate();
        });

        saveButton.addActionListener(save -> {
            List<Shelf> newShelves = new ArrayList<>();
            List<Stone> newStones = new ArrayList<>();

            for (Shelf s : SelectedShelves) {
                newShelves.add(s);
            }
            for (Shelf s : shelves) {
                newShelves.add(s);
            }

            for (Stone s : SelectedStones) {
                newStones.add(s);
            }
            for (Stone s : stones) {
                newStones.add(s);
            }

            for (int i = 0; i < newShelves.size() - 1; i++) {
                for (int j = i + 1; j < newShelves.size(); j++) {
                    if (newShelves.get(i).getName().compareToIgnoreCase(
                            newShelves.get(j).getName()) == 0) {
                        newShelves.remove(j);
                    }
                }
            }
            SelectedShelves.clear();
            shelves.clear();
            for (Shelf s : newShelves) {
                shelves.add(s);
            }
            newShelves.clear();

            for (int i = 0; i < newStones.size() - 1; i++) {
                for (int j = i + 1; j < newStones.size(); j++) {
                    if (newStones.get(i).getPersonalNumber() ==
                            newStones.get(i).getPersonalNumber()) {
                        newStones.remove(j);
                    }
                }
            }
            SelectedStones.clear();
            shelves.clear();
            for(Stone s: newStones){
                stones.add(s);
            }
            newStones.clear();
        });

        jFrame.setVisible(true);
        jFrame.validate();

        Function.recalculateAllField(shelves, stones);

        ShelfXmlWriter.WriteToFile(FILE_SHELVES_NAME, shelves);
        StoneXmlWriter.WriteToFile(FILE_STONES_NAME,stones);

    }
}
