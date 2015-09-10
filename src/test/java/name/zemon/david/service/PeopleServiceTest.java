package name.zemon.david.service;

import name.zemon.david.config.MainConfig;
import name.zemon.david.pojo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by david on 9/9/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MainConfig.class)
public class PeopleServiceTest {
    @Inject
    private PeopleService testable;

    @Transactional
    @Rollback(true)
    @Test
    public void canReadDatabase() throws Exception {
        final Collection<Person> people = this.testable.getPeople();
        assertEquals(2, people.size());
    }
}
