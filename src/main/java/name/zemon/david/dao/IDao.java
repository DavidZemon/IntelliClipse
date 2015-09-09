package name.zemon.david.dao;

import name.zemon.david.pojo.Person;

import java.util.Collection;

/**
 * Created by david on 9/8/15.
 */
public interface IDao {
    Collection<Person> getPeople();
}
