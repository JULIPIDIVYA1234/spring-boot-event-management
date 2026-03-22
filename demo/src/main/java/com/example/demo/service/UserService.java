package com.example.demo.service;

import java.util.Set;

import com.example.demo.entity.Event;
import com.example.demo.entity.User;

public interface UserService {
	User createUser(User user);

    User getUserById(Long id);

    Set<Event> registerEvent(Long userId, Long eventId);

    Set<Event> removeEvent(Long userId, Long eventId);

    Set<Event> getUserEvents(Long userId);
}
