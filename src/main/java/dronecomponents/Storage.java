package dronecomponents;

import configuration.Configuration;

import java.util.Random;


public class Storage {

    private final Section[][] sections;

    public Storage() {

        sections = new Section[Configuration.INSTANCE.sectionElementCount][Configuration.INSTANCE.sectionElementCount];
        for (int i = 0; i < Configuration.INSTANCE.sectionElementCount; i++) {
            for (int j = 0; j < Configuration.INSTANCE.sectionElementCount; j++) {
                sections[i][j] = new Section();
            }
        }

    }

    public Section[][] getSections() {
        return sections;
    }

    public void loadContent() {

        int randomII;
        int randomJJ;

        Random random = new Random();                                           //to choose a random section in the 2D array containing 100 Sections

        randomII = (int) (random.nextFloat() * (Configuration.INSTANCE.sectionElementCount));
        randomJJ = (int) (random.nextFloat() * (Configuration.INSTANCE.sectionElementCount));
        int u = 0;
        for (int i = 0; i < Configuration.INSTANCE.sectionElementCount; i++) {
            for (int j = 0; j < Configuration.INSTANCE.sectionElementCount; j++) {
                if (i == randomII && j == randomJJ) {
                    sections[i][j] = placeHuman(sections[i][j]);                //in this random section is the human placed
                } else {
                    sections[i][j].setContent();                            // otherwise it should set Content normally
                }
            }
        }

        System.out.println("scanning landscape...");
        System.out.println("loading landscape sections..");
    }

    public Section placeHuman(Section section) {//.............

        section.setContent();                                      //since the section contents are still all null---> setContent is not in default Constructor in Section../

        int randomI;
        int randomJ;                                              // placing human in the 2D char array with random i and j
        String human = "human";
        Random random = new Random();

        //the human is placed horizontally, i being the rows, j being the columns
        //since human is placed vertically j plays a major role
        //the random j should be less than equal to (boundary i.e. 50 - length of human string)
        //otherwise human would not fit!!!!

        do {
            randomI = (int) (random.nextFloat() * (Configuration.INSTANCE.sectionElementCount));
            randomJ = (int) (random.nextFloat() * (Configuration.INSTANCE.sectionElementCount));

        } while (randomJ > Configuration.INSTANCE.sectionElementCount - human.length());  //ensuring random J<=49-5
        int i = 0;

        for (int j = randomJ; j < randomJ + human.length(); j++) {
            section.getContent()[randomI][j] = human.charAt(i);        //placing human char to char from random I and random J
            i++;
        }

        return section;

    }

}

