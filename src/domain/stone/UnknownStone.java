package domain.stone;

public class UnknownStone extends Stone{
    private static final Double PRISE_PARAMETER = 0.;

    public void calculatePrise(){
        this.setPrise((int)(this.calculatePrimaryPrise()*PRISE_PARAMETER));
    }
}
