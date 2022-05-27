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
    public void CyclicStickWorks(){

        rescueHelicopter.getCockpitLeft().getCyclic_stick().tiltLeft(2);
        assertEquals(100.0,rescueHelicopter.getMainMotor().getSpeed());
        assertEquals(2,rescueHelicopter.getMainMotor().getAngleRotorBlades());

        Directions expectedDirection=Directions.LEFT;
        assertEquals(expectedDirection,rescueHelicopter.getMainMotor().getDirection());
    }

    @Test
    @Order(3)
    public void CollectivePitchWorks(){

    }


}
