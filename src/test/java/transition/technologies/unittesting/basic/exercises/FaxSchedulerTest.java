package transition.technologies.unittesting.basic.exercises;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author agnieszka
 */
public class FaxSchedulerTest {

    private FaxScheduler faxScheduler;

    public FaxSchedulerTest() {
    }

    @Before
    public void setUp() {
        faxScheduler = new FaxScheduler();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void shouldSendFax() throws MissingOrBadFileException, PhoneFormatException, PhoneAreaCodeException {
        assertTrue(faxScheduler.sendFax("12-1234567", "plik.txt"));
    }

    @Test(expected = PhoneFormatException.class)
    public void shouldBePhoneFormatException_phoneWithCharacter() throws MissingOrBadFileException, PhoneFormatException, PhoneAreaCodeException {
        faxScheduler.sendFax("A2-1234567", "plik.txt");
    }

    @Test(expected = PhoneFormatException.class)
    public void shouldBePhoneFormatException_phoneBadLenght() throws MissingOrBadFileException, PhoneFormatException, PhoneAreaCodeException {
        faxScheduler.sendFax("12-123456", "plik.txt");
    }

    @Test(expected = PhoneFormatException.class)
    public void shouldBePhoneFormatException_phoneBadSplitter() throws MissingOrBadFileException, PhoneFormatException, PhoneAreaCodeException {
        faxScheduler.sendFax("12+1234567", "plik.txt");
    }

    @Test(expected = MissingOrBadFileException.class)
    public void shouldBeMissingOrBadFileException_fileIsMising() throws MissingOrBadFileException, PhoneFormatException, PhoneAreaCodeException {
        faxScheduler.sendFax("12-1234567", null);
    }

    @Test(expected = PhoneAreaCodeException.class)
    public void shouldBePhoneAreaCodeException_coreAreaIsBad() throws MissingOrBadFileException, PhoneFormatException, PhoneAreaCodeException {
        faxScheduler.sendFax("65-1234567", "plik.txt");
    }
}
