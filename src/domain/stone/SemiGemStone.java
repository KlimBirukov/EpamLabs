package domain.stone;

public class SemiGemStone extends UnknownStone {
    private static final Double PRISE_PARAMETER = 1.0185;

    public void calculatePrise(){
        this.setPrise((int)(this.calculatePrimaryPrise()*PRISE_PARAMETER));
    }
}
