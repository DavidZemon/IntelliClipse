package name.zemon.david.common.dao;

import name.zemon.david.common.pojo.Person;

import java.util.Collection;

/**
 * Created by david on 9/8/15.
 */
public interface IDao {
    Collection<Person> getPeople();

    Collection<Person> getPeopleWithFirstName(String firstName);

    void saveAll(Collection<Person> allPeople);

    Person getById(int id);
}
