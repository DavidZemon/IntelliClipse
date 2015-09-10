package name.zemon.david.service;

import name.zemon.david.dao.IDao;
import name.zemon.david.pojo.Person;
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
}
