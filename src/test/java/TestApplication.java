import BasicComponents.Manufacturer;
import BasicComponents.RescueHelicopter;
import CockpitComponents.Directions;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TestApplication {

    RescueHelicopter rescueHelicopter;

    @BeforeEach
    public void setUp(){
        rescueHelicopter=new RescueHelicopter(Manufacturer.AIRBUS);
    }

    @Test
    @Order(1)
    public void testAssertNotNull() {
        assertNotNull(rescueHelicopter.getCockpitLeft());
        assertNotNull(rescueHelicopter.getCockpitRight());
        assertNotNull(rescueHelicopter.getCabin());
        assertNotNull(rescueHelicopter.getMainMotor());
        assertNotNull(rescueHelicopter.getTailRotor());
        assertNotNull(rescueHelicopter.getTechnics());
        assertNotNull(rescueHelicopter.getCentralUnit());
        assertNotNull(rescueHelicopter.getDrone());

    }

    @Test
    @Order(2)
    @DisplayName("Main rotor properties must change accordingly..")
    public void CyclicStickWorks(){

        rescueHelicopter.getCockpitLeft().getCyclic_stick().tiltLeft(3);    //controlling rotor from leftCockpit
        assertEquals(150.0,rescueHelicopter.getMainMotor().getSpeed());
        assertEquals(3,rescueHelicopter.getMainMotor().getAngleRotorBlades());

        Directions expectedDirection=Directions.LEFT;
        assertEquals(expectedDirection,rescueHelicopter.getMainMotor().getDirection());


        rescueHelicopter.getCockpitRight().getCyclic_stick().tiltFront(5);    //controlling rotor from rightCockpit
        assertEquals(250.0,rescueHelicopter.getMainMotor().getSpeed());
        assertEquals(5,rescueHelicopter.getMainMotor().getAngleRotorBlades());

        Directions expectedDirection_=Directions.FORWARD;
        assertEquals(expectedDirection_,rescueHelicopter.getMainMotor().getDirection());
    }

    @Test
    @Order(3)
    public void CollectivePitchWorks(){

        //for right cockpit
        rescueHelicopter.getCockpitRight().getCollective_pitch_control().raiseCollectivePitchControl();
        assertTrue(rescueHelicopter.getMainMotor().getRaise());

        rescueHelicopter.getCockpitRight().getCollective_pitch_control().lowerCollectivePitchControl();
        assertFalse(rescueHelicopter.getMainMotor().getRaise());


        //for left cockpit
        rescueHelicopter.getCockpitLeft().getCollective_pitch_control().raiseCollectivePitchControl();
        assertTrue(rescueHelicopter.getMainMotor().getRaise());

        rescueHelicopter.getCockpitLeft().getCollective_pitch_control().lowerCollectivePitchControl();
        assertFalse(rescueHelicopter.getMainMotor().getRaise());

    }

    @Test
    @Order(4)
    public void AntiTorquePedalsWorks(){

        //right cockpit
        rescueHelicopter.getCockpitRight().getAntiTorquePedalRight().increaseLift();
        assertTrue(rescueHelicopter.getTailRotor().getLiftIncreased());

        //left cockpit
        rescueHelicopter.getCockpitLeft().getAntiTorquePedalLeft().decreaseLift();
        assertFalse(rescueHelicopter.getTailRotor().getLiftIncreased());

    }

    @Test
    @Order(5)
    public void SwitchesWork(){
        rescueHelicopter.getCockpitRight().getControl_panel().switchOnOffLandingLight(true);
        assertTrue(rescueHelicopter.getLandingLight().getIsOn());
    }


}
