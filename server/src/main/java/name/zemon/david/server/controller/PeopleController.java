package name.zemon.david.server.controller;

import name.zemon.david.common.pojo.Person;
import name.zemon.david.common.service.PeopleService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by david on 9/9/15.
 */
@Controller
@RequestMapping("people")
public class PeopleController {
    private final PeopleService peopleService;

    @Inject
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Transactional
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Person> getAll() {
        return this.peopleService.getPeople();
    }

    @Transactional
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Person getById(@PathVariable("id") final int id) {
        return this.peopleService.getById(id);
    }
}
