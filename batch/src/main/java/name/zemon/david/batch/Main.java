package name.zemon.david.batch;

import name.zemon.david.common.pojo.Person;
import name.zemon.david.common.service.PeopleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by david on 9/13/15.
 */
public class Main implements Runnable {
    private final PeopleService peopleService;

    public Main(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        final Runnable main = context.getBean(Runnable.class);
        main.run();
    }

    @Override
    @Transactional
    public void run() {
        final Collection<Person> allPeople = this.peopleService.getPeople();
        allPeople.forEach(person -> {
            person.setFirstName(person.getFirstName().toUpperCase());
            person.setLastName(person.getLastName().toUpperCase());
        });
        this.peopleService.saveAll(allPeople);
    }
}
