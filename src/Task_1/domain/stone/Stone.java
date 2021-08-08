package Task_1.domain.stone;

public abstract class Stone {
    private Integer personalNumber;
    private String type;
    private String name;
    private Integer weight;
    private Double transparency;
    private Integer prise;

    public Stone() {
    }

    public Integer getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(Integer personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Double getTransparency() {
        return transparency;
    }

    public void setTransparency(Double transparency) {
        this.transparency = transparency;
    }

    public Integer getPrise() {
        return prise;
    }

    public void setPrise(Integer prise) {
        this.prise = prise;
    }

    protected Integer calculatePrimaryPrise(){
        return this.getWeight()*1000 + (int)Math.round(this.getTransparency()*1000);
    }

    public void calculatePrise(){
        this.setPrise((int)(this.calculatePrimaryPrise()));
    }

    @Override
    public String toString() {
        return "Stone{" +
                "personalNumber=" + personalNumber +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", transparency=" + transparency +
                ", prise=" + prise +
                '}';
    }
}
