package HumanComponents;

public class Staff extends Human{

    public IDCard idCard;

    public Staff(){
        super(false, false);//no cells are damaged
        idCard=new IDCard();
    }

    public IDCard getIdCard() {
        return idCard;
    }
}
