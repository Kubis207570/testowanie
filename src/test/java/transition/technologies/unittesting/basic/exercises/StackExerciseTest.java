package transition.technologies.unittesting.basic.exercises;

import java.util.Iterator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StackExerciseTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private StackExercise sut;

    @Before
    public void initializeSut() {
        sut = new StackExercise();
    }

    @Test
    public void shouldBeEmptyWhenNothingPushed() {
        pushValuesToStack(0);
        assertTrue(sut.isEmpty());
    }

    @Test
    public void shouldTopReturnLastPushedValue() throws StackEmptyException {
        String added = "AGA";
        sut.push(added);
        String pushed = sut.pop();
        assertEquals(added, pushed);
    }

    @Test
    public void shouldNotFailWhen200ElementsPushed() throws StackEmptyException {
        pushValuesToStack(200);

    }

    private void pushValuesToStack(int numElements) {
        for (int i = 0; i < numElements; i++) {
            sut.push("Element");
        }
    }

    @Test
    public void shouldBeEmptyWhenAllPopped() throws StackEmptyException {
        pushValuesToStack(20);
        for (int i = 0; i < 20; i++) {
            sut.pop();
        }
        assertTrue(sut.isEmpty());
    }

    @Test(expected = StackEmptyException.class)
    public void shouldThrowStackEmptyExceptionWhenEmptyPopped() throws StackEmptyException {
        sut.pop();
    }

}
