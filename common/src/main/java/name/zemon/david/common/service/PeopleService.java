package name.zemon.david.common.service;

import name.zemon.david.common.dao.IDao;
import name.zemon.david.common.pojo.Person;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by david on 9/9/15.
 */
@Service
public class PeopleService {
    private final IDao dao;

    @Inject
    public PeopleService(IDao dao) {
        this.dao = dao;
    }

    public Collection<Person> getPeople() {
        return this.dao.getPeople();
    }

    public void saveAll(final Collection<Person> allPeople) {
        this.dao.saveAll(allPeople);
    }
}
