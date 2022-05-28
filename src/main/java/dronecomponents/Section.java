package dronecomponents;

import configuration.Configuration;

import java.util.Random;

public class Section {

    private final char[][] content = new char[Configuration.INSTANCE.sectionElementCount][Configuration.INSTANCE.sectionElementCount];

    Random random = new Random();

    // the setContent Method sets random alphabets from char pool
    //this is not included in the default constructor, because the camera should be on first and scan the landscape--> setContent
    //the storage cannot already contain the Sections and their contents while the camera is switched off
    // randomly allocation of chars may accidentally place human at many places
    //therefore the do while endures that no human are accidentally put in the section


    public void setContent() {
        char[] charPool = {'a', 'g', 'h', 'm', 'n', 't', 'u', 'w'};
        int randomLimitedInt;
        char[] charAtLine = new char[50];
        for (int i = 0; i < Configuration.INSTANCE.sectionElementCount; i++) {
            do {
                for (int j = 0; j < Configuration.INSTANCE.sectionElementCount; j++) {

                    randomLimitedInt = (int) (random.nextFloat() * (charPool.length));
                    content[i][j] = charPool[randomLimitedInt];
                    charAtLine[j] = content[i][j];
                }
            } while (String.valueOf(charAtLine).contains("human"));
        }
    }


    public char[][] getContent() {
        return content;
    }
}