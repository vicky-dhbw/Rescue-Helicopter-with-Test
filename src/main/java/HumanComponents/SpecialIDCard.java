package HumanComponents;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class SpecialIDCard extends IDCard{

    Date licenceValidTill = new Date();
    private TypeValidation typeValidation;

    private LicenceType licenceType;

    public SpecialIDCard(IDCard idCard){
        super();
        setLicenceType();

    }

    public TypeValidation getTypeValidation() {
        return typeValidation;
    }

    public void setTypeValidation(TypeValidation typeValidation){
        this.typeValidation=typeValidation;
    }


    public void setLicenceValidTill(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd.MM.yyyy");
        licenceValidTill = simpleDateFormat.parse(date);
    }

    public void setLicenceType(){
        int pick = new Random().nextInt(LicenceType.values().length);
        licenceType=LicenceType.values()[pick];
    }


    public LicenceType getLicenceType() {
        return licenceType;
    }
}
