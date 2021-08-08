package Task_1.TableModal;

import Task_1.domain.shelf.Shelf;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class ShelvesTableModel implements TableModel {
    private List<Shelf> shelves;

    public ShelvesTableModel(List<Shelf> shelves) {
        this.shelves = shelves;
    }

    @Override
    public int getRowCount() {
        return shelves.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "name";
            case 1 -> "totalWeight";
            case 2 -> "amountOfStones";
            case 3 -> "totalPrise";
            default -> throw new IllegalStateException("Unexpected value: " + columnIndex);
        };
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> String.class;
            case 1, 2, 3 -> Integer.class;
            default -> throw new IllegalStateException("Unexpected value: " + columnIndex);
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> true;
            case 1, 2, 3 -> false;
            default -> throw new IllegalStateException("Unexpected value: " + columnIndex);
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> shelves.get(rowIndex).getName();
            case 1 -> shelves.get(rowIndex).getTotalWeight();
            case 2 -> shelves.get(rowIndex).getAmountOfStone();
            case 3 -> shelves.get(rowIndex).getTotalPrise();
            default -> throw new IllegalStateException("Unexpected value: " + columnIndex);
        };
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }

    public List<Shelf> getShelves(int[] indexes) {
        List<Shelf> result = new ArrayList<>();
        for (int index : indexes) {
            result.add(shelves.get(index));
        }
        return result;
    }
}
