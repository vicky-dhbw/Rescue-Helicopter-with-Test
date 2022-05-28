package DroneComponents;
import Configuration.*;

import java.util.Arrays;
import java.util.Random;

public class DroneCentralUnit {

    private Camera camera;
    private Storage storage;

    //since drone central unit must control the camera and storage, the two are given as parameter in default constructor
    public DroneCentralUnit(Camera camera, Storage storage) {
        this.camera=camera;
        this.storage=storage;
    }

    public void switchOnCamera(){
        camera.setIsOn(true);
        System.out.println("Camera switched on..");
        storage.loadContent();                                //when the camera is switched on the contents are loaded...
                                                             // Note loadContent has both setContent and placeHuman methods
        searchHuman();                                      //after loading contents off all sections of the landscape...
                                                           // the drone searches for "human" placed in a random section in random coordinates
    }
    public void switchOffCamera(){
        camera.setIsOn(false);
        System.out.println("Camera switched off..");

    }

    public boolean searchHuman() {

        int sectionCoordinateI;
        int sectionCoordinateJ;

        int inSectionK;
        int inSectionL;


        Section section;
        String arrayAsString;
        char[] arrayCopy = new char[Configuration.INSTANCE.sectionElementCount];

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                section = storage.getSections()[i][j];                //first getting section from storage and then looking in it for "human" through 2 loops
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
                        System.out.println("human found in Section in coordinate--> X: " + sectionCoordinateI + " ,Y: " + sectionCoordinateJ);
                        System.out.println("In the above section is human to be found at coordinates ---> x: " + inSectionK + " ,y: " + inSectionL);
                        return true;
                    }

                }

            }
        }
        return false;
    }

    public Camera getCamera(){
        return camera;
    }

    public Storage getStorage(){
        return storage;
    }
}


