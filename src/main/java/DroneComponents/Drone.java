package DroneComponents;

import BasicComponents.*;
import CockpitComponents.Switch;

public class Drone {

    private boolean isDetached;

    private final Camera camera;
    private final DroneCentralUnit droneCentralUnit;

    private final Storage storage;


    public Drone() {
        isDetached=false;
        this.storage = new Storage();
        this.camera = new Camera();
        this.droneCentralUnit = new DroneCentralUnit(camera,storage);
    }

    public Camera getCamera(){
        return camera;
    }

    public Storage getStorage(){
        return storage;
    }

    public DroneCentralUnit getCameraCentralUnit(){
        return droneCentralUnit;
    }

    public void detach(){
        isDetached=true;
        System.out.println("detaching drone from helicopter...");
        System.out.println("drone set free..");
    }

    public boolean getIsDetached(){

        return isDetached;
    }

    public DroneCentralUnit getDroneCentralUnit(){
        return droneCentralUnit;
    }

    public void attach(){
        isDetached=false;
        System.out.println("drone automatically attached to helicopter...");
    }

}

