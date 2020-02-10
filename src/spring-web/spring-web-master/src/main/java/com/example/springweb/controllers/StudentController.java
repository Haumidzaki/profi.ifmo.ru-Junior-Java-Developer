package com.example.springweb.controllers;

import com.example.springweb.entity.Event;
import com.example.springweb.entity.Student;
import com.example.springweb.entity.University;
import com.example.springweb.repositories.EventRepository;
import com.example.springweb.repositories.StudentRepository;
import com.example.springweb.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private EventRepository eventRepository;




    @RequestMapping(value = "/student/add", method= RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("universities", universityRepository.findAll());
        model.addAttribute("events", eventRepository.findAll());
        model.addAttribute("student", new Student());
        return "add_student";
    }


    @RequestMapping(value = "/student/add", method= RequestMethod.POST)
    public String submitForm(@ModelAttribute Student student, Model model,
                             @RequestParam(name = "universityId") String universityId,
                             @RequestParam(name = "eventId") String eventId) {

        University university = universityRepository.findById(Integer.valueOf(universityId)).get();
        Event event = eventRepository.findById(Integer.valueOf(eventId)).get();

        String code = student.getStudentCode();
        boolean isPresent = studentRepository.findByCode(code).isPresent();

        if (isPresent) {
            Student presentParticipant = studentRepository.findByCode(code).get();
            updateParticipantRegInfo(presentParticipant, event, university);
            studentRepository.save(presentParticipant);
        } else {
            updateParticipantRegInfo(student, event, university);
            studentRepository.save(student);
        }


        model.addAttribute("universities", universityRepository.findAll());
        model.addAttribute("events", eventRepository.findAll());
        model.addAttribute("student", new Student());
        return "add_student";
    }

    private void updateParticipantRegInfo(Student participant, Event event, University university){
        participant.getEvents().add(event);
        participant.setUniversity(university);


        university.getStudents().add(participant);
        event.getStudents().add(participant);
    }
}
