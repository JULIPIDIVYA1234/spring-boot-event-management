📌 Event Management System (Backend)

A backend-focused event management platform built using Spring Boot, designed to handle real-world user-event interactions with scalable architecture and clean separation of concerns.

🚀 Problem Statement

Managing events isn’t just CRUD.
It involves:

Handling user registrations at scale
Maintaining data consistency in relationships
Enforcing secure access control
Supporting efficient data retrieval

This project solves these using a structured backend system.

🧠 Key Features
🔐 Authentication & Authorization
JWT-based authentication
Role-based access (Admin / User)
📅 Event Management
Create, update, delete events
Register/unregister users
🔗 Relationship Handling
Many-to-Many mapping (Users ↔ Events)
📊 Performance Optimization
Pagination & sorting for large datasets
🧱 Layered Architecture
Controller → Service → Repository
🛠 Tech Stack
Java
Spring Boot
Spring Security
JWT
JPA / Hibernate
MySQL
Postman (API testing)
React (Frontend - optional)
🏗️ Project Structure
src/main/java/com/project
│
├── controller     # Handles HTTP requests
├── service        # Business logic
├── repository     # Database interactions
├── entity         # JPA entities
├── security       # JWT & auth config
└── dto            # Data transfer objects
⚙️ API Endpoints (Sample)
Method	Endpoint	Description
POST	/auth/register	Register user
POST	/auth/login	Authenticate user
GET	/events	Get all events
POST	/events	Create event (Admin)
POST	/events/{id}/register	Register for event
🔑 Key Learnings
Designing entity relationships early prevents major refactoring later
JWT integration requires careful handling of filters and security context
Pagination is essential once data grows — not optional
Clean architecture improves maintainability and testing
⚠️ Challenges Faced
Managing Many-to-Many relationships without performance issues
Securing endpoints with role-based access
Structuring scalable service layers
📈 Future Improvements
Redis caching
API rate limiting
Microservices architecture
Docker deployment
▶️ How to Run
Clone the repository
Configure MySQL in application.properties
Run the application
Use Postman to test APIs
📬 Contribution

Open to suggestions and improvements. Feel free to fork and contribute.
