# Software Engineer CRUD API (Spring Boot Practice Project)

This is a practice project for implementing a full CRUD (Create, Read, Update, Delete) RESTful API using Spring Boot. The project focuses on managing `SoftwareEngineer` entities and demonstrates the use of Data Transfer Objects (DTOs) to decouple the internal model from external API representation.

## 🚀 Features

- Create a new software engineer
- Get all software engineers
- Get a software engineer by ID
- Update a software engineer
- Delete a software engineer
- Uses DTO pattern for cleaner separation between internal entities and API payloads
- Error handling using `ResponseEntity`

## 📦 Technologies Used

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL (configurable)
- Lombok (optional for cleaner code)
- Maven


## 🧩 Entity & DTO

- `SoftwareEngineer` – JPA entity mapped to the database
- `SoftwareEngineerDTO` – Data Transfer Object used to interact with the API (excluding sensitive or unnecessary internal fields)

## 📮 API Endpoints

| Method | Endpoint                                            | Description                    |
|--------|-----------------------------------------------------|--------------------------------|
| GET    | `api/v1/software-engineers/get-all`                 | Get all software engineers     |
| GET    | `api/v1/software-engineers/software-engineers/{id}` | Get software engineer by ID    |
| POST   | `api/v1/software-engineers/add`                     | Create new software engineer   |
| PUT    | `api/v1/software-engineers/update/{id}`             | Update existing engineer       |
| DELETE | `api/v1/software-engineers/delete/{id}`             | Delete software engineer       |


## 🛠 Sample `SoftwareEngineerDTO`

```json
{
  "name": "Jane Doe",
  "techStack":"java, springboot"
}
