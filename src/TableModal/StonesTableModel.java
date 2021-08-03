package TableModal;

import domain.stone.Stone;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class StonesTableModel implements TableModel {
    private List<Stone> stones;

    public StonesTableModel(List<Stone> stones) {
        this.stones = stones;
    }

    @Override
    public int getRowCount() {
        return stones.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "type";
            case 1 -> "name";
            case 2 -> "weight";
            case 3 -> "transparency";
            case 4 -> "prise";
            default -> throw new IllegalStateException("Unexpected value: " + columnIndex);
        };
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0, 1 -> String.class;
            case 2, 4 -> Integer.class;
            case 3 -> Double.class;
            default -> throw new IllegalStateException("Unexpected value: " + columnIndex);
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0, 1, 4 -> false;
            case 2, 3 -> true;
            default -> throw new IllegalStateException("Unexpected value: " + columnIndex);
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> stones.get(rowIndex).getType();
            case 1 -> stones.get(rowIndex).getName();
            case 2 -> stones.get(rowIndex).getWeight();
            case 3 -> stones.get(rowIndex).getTransparency();
            case 4 -> stones.get(rowIndex).getPrise();
            default -> throw new IllegalStateException("Unexpected value: " + columnIndex);
        };
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> stones.get(rowIndex).setType((String) aValue);
            case 2 -> stones.get(rowIndex).setName((String) aValue);
            case 3 -> stones.get(rowIndex).setWeight((Integer) aValue);
            case 4 -> stones.get(rowIndex).setTransparency((Double) aValue);
            case 5 -> stones.get(rowIndex).setPrise((Integer) aValue);
            default -> throw new IllegalStateException("Unexpected value: " + columnIndex);
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {    }

    @Override
    public void removeTableModelListener(TableModelListener l) {    }

    public List<Stone> getStones(int[] indexes) {
        List<Stone> result = new ArrayList<>();
        for (int index : indexes) {
            result.add(stones.get(index));
        }
        return result;
    }
}
