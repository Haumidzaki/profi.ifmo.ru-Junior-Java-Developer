package com.example.springweb.specifications;

import com.example.springweb.entity.Event;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class EventSpecification {
    // событие по названию
    public static Specification<Event> eventByTitle(final String title)  {
        return (Specification<Event>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("eventTitle"), title);
    }


}
