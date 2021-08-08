package Task_1.domain.stone;

public class GemStone extends UnknownStone {
    private static final Double PRISE_PARAMETER = 1.3134;

    public void calculatePrise(){
        this.setPrise((int)(this.calculatePrimaryPrise()*PRISE_PARAMETER));
    }
}
