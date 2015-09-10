package name.zemon.david.controller;

import name.zemon.david.service.MessageService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

/**
 * Created by david on 9/9/15.
 */
@Controller
@RequestMapping("message")
public class MessageController {
    private final MessageService messageService;

    @Inject
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getHello() {
        return this.messageService.run();
    }
}
