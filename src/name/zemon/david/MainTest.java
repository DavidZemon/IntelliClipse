package name.zemon.david;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by david on 9/8/15.
 */
public class MainTest {
    private Main testable;

    @Before
    public void setUp() throws Exception {
        testable = new Main();
    }

    @Test
    public void shouldReturnHello() throws Exception {
        assertEquals("Hello", testable.run());
    }
}
