package name.zemon.david.common.dao;

import name.zemon.david.common.pojo.Person;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by david on 9/8/15.
 */
@SuppressWarnings("unchecked")
@Repository
public class Dao implements IDao {
    private final SessionFactory sessionFactory;

    @Inject
    public Dao(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Collection<Person> getPeople() {
        return this.sessionFactory.getCurrentSession()
                .createCriteria(Person.class)
                .list();
    }

    @Override
    public void saveAll(Collection<Person> allPeople) {
        allPeople.forEach(person -> this.sessionFactory.getCurrentSession().save(person));
    }
}
