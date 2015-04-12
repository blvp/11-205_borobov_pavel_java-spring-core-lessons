package foo.bar.controller;

import foo.bar.service.ApplicationUtils;
import foo.bar.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by blvp on 10.04.15.
 */
@Controller
@RequestMapping("event")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    ApplicationUtils applicationUtils;

    @RequestMapping(value = "{id:[0-9]+}", method = RequestMethod.GET)
    public ResponseEntity renderOne(Model model, @PathVariable Long id){
//        Event eventById = eventService.getEventById(id);
//        model.addAttribute("event", eventById);


        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
