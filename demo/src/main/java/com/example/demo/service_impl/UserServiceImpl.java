package com.example.demo.service_impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Event;
import com.example.demo.entity.User;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    } 
    
    
    /*****
          
          @Override
public User getUserById(Long id) {

    Optional<User> optionalUser = userRepository.findById(id);

    if (optionalUser.isPresent()) {
        return optionalUser.get();
    } else {
        throw new RuntimeException("User not found");
    }
}
          
     ***/
    
    
    
    @Override
    public Set<Event> registerEvent(Long userId, Long eventId) {
        User user = getUserById(userId);
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        user.getEvents().add(event);

        userRepository.save(user);

        return user.getEvents();
    }

    @Override
    public Set<Event> removeEvent(Long userId, Long eventId) {
        User user = getUserById(userId);
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        user.getEvents().remove(event);

        userRepository.save(user);

        return user.getEvents();
    }

    @Override
    public Set<Event> getUserEvents(Long userId) {
        return getUserById(userId).getEvents();
    }
	

}
