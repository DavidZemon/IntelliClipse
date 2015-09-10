package name.zemon.david.service;

import name.zemon.david.config.MainConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

/**
 * Created by david on 9/8/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MainConfig.class)
public class MessageServiceTest {
    @Inject
    private MessageService testable;

    @Test
    public void shouldReturnHello() throws Exception {
        assertEquals("Hello", testable.run());
    }

}
