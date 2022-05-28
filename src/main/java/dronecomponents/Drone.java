package dronecomponents;

public class Drone {

    private final Camera camera;
    private final DroneCentralUnit droneCentralUnit;            // the DroneCentral Unit controls the camera and the storage
    private final Storage storage;
    private boolean isDetached;


    public Drone() {
        isDetached = false;
        this.storage = new Storage();
        this.camera = new Camera();
        this.droneCentralUnit = new DroneCentralUnit(camera, storage);
    }

    public Camera getCamera() {
        return camera;
    }

    public Storage getStorage() {
        return storage;
    }


    public void detach() {
        isDetached = true;
        System.out.println("detaching drone from helicopter...");
        System.out.println("drone set free..");
    }

    public boolean getIsDetached() {

        return isDetached;
    }

    public DroneCentralUnit getDroneCentralUnit() {
        return droneCentralUnit;
    }

    public void attach() {
        isDetached = false;
        System.out.println("drone automatically attached to helicopter...");
    }

}

