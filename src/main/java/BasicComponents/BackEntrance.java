package BasicComponents;

import CockpitComponents.Switch;

public class BackEntrance {

    private boolean isOpen=false;

    public void openBackEntrance(){
        isOpen=true;
        System.out.println("--> opening back doors..  ..I   I..");
    }

    public void closeBackEntrance(){
        isOpen=false;
        System.out.println("--> closing back doors..  ..II..");
    }
}
