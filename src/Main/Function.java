package Main;

import domain.shelf.Shelf;
import domain.stone.Stone;

import java.util.List;

public class Function {
    public static void recalculateField(List<Stone> stones, Shelf shelf) {
        shelf.setTotalWeight(0);
        shelf.setAmountOfStone(0);
        shelf.setTotalPrise(0);

        Integer newTotalWeight = 0;
        Integer newAmountOfStones = 0;
        Integer newTotalPrise = 0;

        for (Stone s : stones) {
            newTotalWeight += s.getWeight();
            newAmountOfStones++;
            newTotalPrise += s.getPrise();
        }
        shelf.setTotalWeight(newTotalWeight);
        shelf.setAmountOfStone(newAmountOfStones);
        shelf.setTotalPrise(newTotalPrise);
    }

    public static void recalculateAllField(List<Shelf> shelves, List<Stone> stones) {
        for (Stone s : stones) {
            s.calculatePrise();
        }

        for (Shelf s : shelves) {
            int weight = 0;
            int count = 0;
            int prise = 0;
            for(Stone t: stones){
                if(s.getName().compareToIgnoreCase(t.getType())==0){
                    weight += t.getWeight();
                    count++;
                    prise += t.getPrise();
                }
            }
            s.setTotalWeight(weight);
            s.setAmountOfStone(count);
            s.setTotalPrise(prise);
        }
    }

    public void countUpField(Stone stone, Shelf shelf) {
        shelf.setTotalWeight(shelf.getTotalWeight() + stone.getWeight());
        shelf.setAmountOfStone(shelf.getAmountOfStone() + 1);
        shelf.setTotalPrise(shelf.getTotalPrise() + stone.getPrise());
    }

}
