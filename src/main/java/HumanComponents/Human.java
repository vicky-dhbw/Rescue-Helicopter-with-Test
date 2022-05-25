package HumanComponents;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Human {
    private final String firstName;
    private final String secondName;
    private final Gender gender;
    private final Date date;
    private final boolean smoker;
    private final boolean vaccinated;
    private final Lung leftLung;
    private final Lung rightLung;

    private final boolean isAlive;

    public Human(String firstName, String secondName, Gender gender, Date date, boolean smoker, boolean vaccinated){
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
        this.date = date;
        this.smoker = smoker;
        this.vaccinated = vaccinated;
        leftLung = new Lung(smoker);
        rightLung = new Lung(smoker);
        leftLung.setCells();
        rightLung.setCells();
        isAlive = true;
    }
    public void breatheIn(){
        leftLung.fillLung();
        rightLung.fillLung();
    }
    public void breatheOut(){
        leftLung.emptyLung();
        rightLung.emptyLung();
    }
}
