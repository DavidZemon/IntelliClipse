package name.zemon.david;

import name.zemon.david.dao.IDao;
import name.zemon.david.pojo.Person;

import java.util.Collection;

public class Main {
    private final IDao dao;

    public Main(IDao dao) {
        this.dao = dao;
    }

    public String run() {
        return "Hello";
    }

    public Collection<Person> getPeople() {
        return this.dao.getPeople();
    }
}
