package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.entity.Event;

public interface EventService {

    Event createEvent(Event event);

    Page<Event> getAllEvents(int page, int size, String sort);

    Event getEventById(Long id);

    Event updateEvent(Long id, Event event);

    void deleteEvent(Long id);
}
 