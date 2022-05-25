package DroneComponents;
import Configuration.*;

import java.util.Arrays;
import java.util.Random;

public class DroneCentralUnit {

    Camera camera;
    Storage storage;
    public DroneCentralUnit(Camera camera, Storage storage) {
        this.camera=camera;
        this.storage=storage;
    }

    public void switchOnCamera(){
        camera.setIsOn(true);
        System.out.println("Camera switched on..");
        storage.loadContent();
       searchHuman();
    }
    public void switchOffCamera(){
        camera.setIsOn(false);
        System.out.println("Camera switched off..");

    }

    public void searchHuman() {

        int sectionCoordinateI;
        int sectionCoordinateJ;

        int inSectionK;
        int inSectionL;

        boolean breakLoops = false;
        Section section;
        String arrayAsString;
        char[] arrayCopy = new char[Configuration.INSTANCE.sectionElementCount];

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                section = storage.getSections()[i][j];
                for (int k = 0; k < 50; k++) {
                    for (int l = 0; l < 50; l++) {
                        arrayCopy[l] = section.getContent()[k][l];
                    }
                    arrayAsString = String.valueOf(arrayCopy);
                    if (arrayAsString.contains("human")) {
                        sectionCoordinateI = i;
                        sectionCoordinateJ = j;
                        inSectionK = k;
                        inSectionL = arrayAsString.indexOf("human");
                        breakLoops = true;
                        System.out.println("human found in Section in coordinate--> X: " + sectionCoordinateI + " ,Y: " + sectionCoordinateJ);
                        System.out.println("In the above section is human to be found at coordinates ---> x: " + inSectionK + " ,y: " + inSectionL);
                        break;
                    }

                }
                if (breakLoops) {
                    break;
                }

            }
            if (breakLoops) {
                break;
            }

        }
    }
}


