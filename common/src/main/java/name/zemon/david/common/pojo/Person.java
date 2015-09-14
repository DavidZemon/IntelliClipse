package name.zemon.david.common.pojo;

import javax.persistence.*;

/**
 * Created by david on 9/8/15.
 */
@Entity
@Table(name = "PEOPLE", schema = "", catalog = "intelliclipse")
public class Person {
    private int     id;
    private String  firstName;
    private String  lastName;
    private Boolean enlightened;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "ENLIGHTENED")
    public Boolean getEnlightened() {
        return enlightened;
    }

    public void setEnlightened(Boolean enlightened) {
        this.enlightened = enlightened;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        if (enlightened != null ? !enlightened.equals(person.enlightened) : person.enlightened != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (enlightened != null ? enlightened.hashCode() : 0);
        return result;
    }
}
