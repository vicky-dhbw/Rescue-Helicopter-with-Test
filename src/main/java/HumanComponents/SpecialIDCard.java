package HumanComponents;

import java.util.Date;

public class SpecialIDCard extends IDCard{
    Date licenceValidTill = new Date();
    private final TypeValidation typeValidation;
    public SpecialIDCard(TypeValidation typeValidation){
        this.typeValidation = typeValidation;
    }
}
