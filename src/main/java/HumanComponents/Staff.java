package HumanComponents;

public class Staff extends Human {

    public IDCard idCard;

    public Staff() {
        super(false);                 //no cells are damaged
    }

    public IDCard getIdCard() {
        return idCard;
    }
}
