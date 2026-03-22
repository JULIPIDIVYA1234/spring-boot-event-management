package com.example.demo.entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.*; 
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String role;  // ROLE_ADMIN or ROLE_USER
	    @Column(unique = true)
	    private String email;
	    private String password;
	    @ManyToMany
	    @JoinTable(name = "user_event",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "event_id"))
	    private Set<Event> events = new HashSet<>();
}
