# Project Hub Back-End

## Description

Project Hub is a comprehensive project management tool designed to facilitate collaboration and productivity. With a full-stack implementation using Java, Spring Boot, Spring Security, React.js, ShadCN, and MySQL, Project Hub offers a range of features to manage projects efficiently.

## Technologies Used

- Java
- Spring Boot
- Spring Security
- MySQL

## Getting Started

1. Clone the repository:
   ```sh
   git clone https://github.com/Pycreater/ProjcetManagementSystem.git
2. Navigate to the project directory:
   ```sh
   cd ProjcetManagementSystem
3. Configure the database settings in `src/main/resources/application.properties`:
   
   ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/yourDatabase
   spring.datasource.username=yourUsername
   spring.datasource.password=yourPassword
   ```
4. Build and run the application:
   ```sh
   ./mvnw spring-boot:run

## Endpoints

- `POST /api/auth/signup` : User registration
- `POST /api/auth/login` : User login
- `POST /api/projects` : Create a new project
- `POST /api/projects/invite` : Send email invitation to join a project
- `GET /api/projects` : List all projects
- `GET /api/projects/{id}` : Get project details
- `POST /api/projects/{id}/issues` : Create a new issue
- `POST /api/issues/{id}/comments` : Comment on an issue
- `POST /api/chat` : Send a real-time chat message

### Contribution

Feel free to contribute to this project by opening a pull request or raising an issue.

* * *

### License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

### Contact

For any inquiries or feedback, please reach out to me at [pratikyadav3949@gmail.com](mailto:pratikyadav3949@gmail.com)

