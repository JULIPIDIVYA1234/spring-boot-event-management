package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Event;
import com.example.demo.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {
	 @Autowired
	    private EventService eventService;

	    @PostMapping
	    public Event createEvent(@RequestBody Event event) {
	        return eventService.createEvent(event);
	    }

	    @GetMapping
	    public Page<Event> getAllEvents(
	            @RequestParam int page,
	            @RequestParam int size,
	            @RequestParam(defaultValue = "name") String sort
	    ) {
	        return eventService.getAllEvents(page, size, sort);
	    }

	    @GetMapping("/{id}")
	    public Event getEventById(@PathVariable Long id) {
	        return eventService.getEventById(id);
	    }

	    @PutMapping("/{id}")
	    public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
	        return eventService.updateEvent(id, event);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteEvent(@PathVariable Long id) {
	        eventService.deleteEvent(id);
}
}