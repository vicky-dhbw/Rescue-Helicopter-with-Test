package HumanComponents;

public class Staff extends Human{
    private String personalNumber;
    private final IDCard idCard;
    public Staff(){
        super(false, false);//no cells are damaged
        idCard = new IDCard();
    }
    public void setPersonalNumber(){
    }
}
