package domain.shelf;

public class Shelf {
    private String name;
    private Integer totalWeight;
    private Integer amountOfStone;
    private Integer totalPrise;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Integer totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Integer getAmountOfStone() {
        return amountOfStone;
    }

    public void setAmountOfStone(Integer amountOfStone) {
        this.amountOfStone = amountOfStone;
    }

    public Integer getTotalPrise() {
        return totalPrise;
    }

    public void setTotalPrise(Integer totalPrise) {
        this.totalPrise = totalPrise;
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "name='" + name + '\'' +
                ", totalWeight=" + totalWeight +
                ", amountOfStone=" + amountOfStone +
                ", totalPrise=" + totalPrise +
                '}';
    }
}
