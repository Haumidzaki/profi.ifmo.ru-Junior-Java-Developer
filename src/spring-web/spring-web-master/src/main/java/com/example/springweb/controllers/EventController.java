package com.example.springweb.controllers;

import com.example.springweb.entity.Event;
import com.example.springweb.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static com.example.springweb.specifications.EventSpecification.eventByTitle;

@Controller
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(value = "/event/add", method = RequestMethod.GET)
    public String showFrom(Model model) {
        model.addAttribute("event", new Event());
        return "add_event";
    }

    @RequestMapping(value = "/event/add", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute Event event, Model model){
        eventRepository.save(event);
        return "add_event";
    }

    @RequestMapping(value = "/event/info", method = RequestMethod.GET)
    public String infoForm(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "event_info";
    }

    @RequestMapping(value = "/event/info", method = RequestMethod.POST)
    public String showInfo(Model model,
                           @RequestParam(name = "eventId", required = false) int eventId) {

//        eventRepository.findOne(eventByTitle(название события)).get();

        model.addAttribute("events", eventRepository.findById(eventId));
        return "event_info";
    }
}
