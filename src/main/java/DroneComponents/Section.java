package DroneComponents;
import Configuration.*;

import java.lang.reflect.Array;
import java.util.Random;


import java.util.Random;

public class Section {

    private final char[][] content=new char[Configuration.INSTANCE.sectionElementCount][Configuration.INSTANCE.sectionElementCount];

    Random random= new Random();

    public void setContent(){
        char[] charPool={'a','g','h','m','n','t','u','w'};
        int randomLimitedInt;
        char[] charAtLine=new char[50];
        for(int i=0;i<Configuration.INSTANCE.sectionElementCount;i++){
            do{
                for(int j=0; j<Configuration.INSTANCE.sectionElementCount;j++){

                    randomLimitedInt = (int) (random.nextFloat() * (charPool.length));
                    content[i][j]=charPool[randomLimitedInt];
                    charAtLine[j]= content[i][j];
                }
            } while (String.valueOf(charAtLine).contains("human"));
        }
    }


    public char[][] getContent(){
        return content;
    }
}