package HumanComponents;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class SpecialIDCard extends IDCard {

    Date licenceValidTill = new Date();
    private TypeValidation typeValidation;

    private LicenceType licenceType;

    public SpecialIDCard() {
        super();
        setLicenceType();
        setTypeValidation();

    }

    public TypeValidation getTypeValidation() {
        return typeValidation;
    }

    public void setTypeValidation() {
        int pick = new Random().nextInt(TypeValidation.values().length);
        typeValidation = TypeValidation.values()[pick];
    }


    public void setLicenceValidTill(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        licenceValidTill = simpleDateFormat.parse(date);
    }

    public void setLicenceType() {
        int pick = new Random().nextInt(LicenceType.values().length);
        licenceType = LicenceType.values()[pick];
    }


    public LicenceType getLicenceType() {
        return licenceType;
    }
}
