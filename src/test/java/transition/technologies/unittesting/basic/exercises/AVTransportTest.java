package transition.technologies.unittesting.basic.exercises;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author agnieszka
 */
public class AVTransportTest {

    private AVTransport aVTransport;

    public AVTransportTest() {
    }

    @Before
    public void setUp() {
        aVTransport = new AVTransport();
    }

    @Test
    public void shouldFastForward() {
        aVTransport.fastForward(20);
        assertEquals(aVTransport.currentTimePosition(), 20, 1e-15);
    }

    @Test
    public void shouldRewind() {
        aVTransport.fastForward(30);
        aVTransport.rewind(10);
        assertEquals(aVTransport.currentTimePosition(), 20, 1e-15);
    }
}
