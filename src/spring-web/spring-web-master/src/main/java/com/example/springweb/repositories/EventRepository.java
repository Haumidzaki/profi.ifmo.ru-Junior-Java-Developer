package com.example.springweb.repositories;

import com.example.springweb.entity.Event;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer>, JpaSpecificationExecutor<Event> {
}
