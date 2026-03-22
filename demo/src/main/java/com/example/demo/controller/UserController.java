package com.example.demo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.*;

import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/{userId}/register/{eventId}")
    public Set<Event> registerEvent(
            @PathVariable Long userId,
            @PathVariable Long eventId
    ) {
        return userService.registerEvent(userId, eventId);
    }

    @DeleteMapping("/{userId}/remove/{eventId}")
    public Set<Event> removeEvent(
            @PathVariable Long userId,
            @PathVariable Long eventId
    ) {
        return userService.removeEvent(userId, eventId);
    }

    @GetMapping("/{userId}/events")
    public Set<Event> getUserEvents(@PathVariable Long userId) {
        return userService.getUserEvents(userId);
    }
}
