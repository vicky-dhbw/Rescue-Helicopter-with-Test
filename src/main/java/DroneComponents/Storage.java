package DroneComponents;
import Configuration.*;

import java.util.Random;


public class Storage {

    private Section[][] sections;
    public Storage(){

        sections=new Section[Configuration.INSTANCE.sectionElementCount][Configuration.INSTANCE.sectionElementCount];
        for(int i=0;i<Configuration.INSTANCE.sectionElementCount;i++){
            for(int j=0;j<Configuration.INSTANCE.sectionElementCount;j++){
                sections[i][j]=new Section();
            }
        }

    }

    public Section[][] getSections(){
        return sections;
    }

    public void loadContent(){

        int randomII;
        int randomJJ;

        Random random=new Random();

        randomII=(int) (random.nextFloat() * (Configuration.INSTANCE.sectionElementCount));
        randomJJ=(int) (random.nextFloat() * (Configuration.INSTANCE.sectionElementCount));
        int u=0;
        for(int i=0;i<Configuration.INSTANCE.sectionElementCount;i++){
            for(int j=0;j<Configuration.INSTANCE.sectionElementCount;j++){
                if(i==randomII&& j==randomJJ){
                    sections[i][j]=placeHuman(sections[i][j]);
                }
                else {
                    sections[i][j].setContent();
                }
            }
        }

        System.out.println("scanning landscape...");
        System.out.println("loading landscape sections..");
    }
    public Section placeHuman(Section section){

        section.setContent();
        int randomI;
        int randomJ;
        String human="human";
        Random random=new Random();

        do{
            randomI=(int) (random.nextFloat() * (Configuration.INSTANCE.sectionElementCount));
            randomJ=(int) (random.nextFloat() * (Configuration.INSTANCE.sectionElementCount));

        }while (randomJ>Configuration.INSTANCE.sectionElementCount-human.length());
        int i=0;

        for(int j=randomJ;j<randomJ+human.length();j++){
            section.getContent()[randomI][j]=human.charAt(i);
            i++;
        }

        return section;

    }

}

