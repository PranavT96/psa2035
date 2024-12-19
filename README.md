# PSA2035 Project

Welcome to the **PSA2035** project repository! This project serves as a comprehensive solution for managing and tracking activities, designed with scalability and efficiency in mind.

## Features

- **User Management**: Create, update, and manage user accounts.
- **Scalable Design**: Optimized for performance and easy to scale.
- **API Testing**: Endpoints tested using Postman.

## Technologies Used

- **Backend**: Java
- **Database**: MySQL
- **Frameworks**: Hibernate, Spring
- **Tools**: Postman (for API testing), Int
- **Version Control**: Git
- **IDE**: IntelliJ IDEA

## Prerequisites

Ensure you have the following installed:

- Java Development Kit (JDK) 8 or later
- Apache Tomcat 9.0 or later
- MySQL 5.7 or later
- Maven (for dependency management)
- Git (for cloning the repository)
- Postman (for API testing)

## Getting Started

1. **Clone the Repository/Download project file**

   ```bash
   git clone https://github.com/PranavT96/psa2035.git
   ```

2. **Import the Project**

   - Open IntelliJ IDEA.
   - Click on `File` → `New` → `Project from Existing Sources`.
   - Select the project directory (`psa2035`) and click `OK`.
   - Choose `Import project from external model` and select `Maven`. Click `Next`.
   - Ensure all dependencies are resolved, then click `Finish`.

3. **Set Up the Database**

   - Create a MySQL database named `crmdb1`.
   - Run the provided SQL script to set up the tables.
   - Update the `application.properties` file with your database credentials.


4. **Run the Application**

   - Click `Apply` and then `OK` to save the configuration.
   - Click the green `Run` button or press `Shift + F10` to start the server.
   - IntelliJ will start Tomcat, and you can access the application at:

     ```
     http://localhost:8080/api/v1/employee
     ```
5. **Test APIs with Postman**

   - Use the provided Postman collection (`/postman/psa2035_collection.json`) to test the API endpoints.
   - Alternatively, import the `Employee Api test.postman_collection.json` file available in the repository to Postman.

   ### Using the Postman Collection

   1. Open Postman and click on "Import."
   2. Select the `Employee Api test.postman_collection.json` file.
   3. 
   4. The collection includes requests for operations such as:
      - Adding an employee (`POST`)
      - Updating employee details (`PUT`)
      - Fetching all employees (`GET`)
      - Fetching an employee by ID (`GET`)
      - Deleting an employee (`DELETE`)
      - Pagination and other features
   5. Adjust the environment variables (e.g., `localhost` and `port`) as needed to suit your setup.

## Project Structure

```
psa2035/
|-- src/main/
|   |-- java/       # Backend Java code
|   |-- resources/  # Configuration files
|   |-- webapp/     # JSP pages and static resources
|-- db/             # Database schema and sample data
|-- postman/        # Postman collections and environment files
|-- pom.xml         # Maven configuration
```

## Contributing

We welcome contributions! Please follow these steps:

1. Fork the repository.
2. Create a feature branch:

   ```bash
   git checkout -b feature/your-feature-name
   ```

3. Commit your changes:

   ```bash
   git commit -m "Add your message here"
   ```

4. Push to your fork:

   ```bash
   git push origin feature/your-feature-name
   ```

5. Submit a Pull Request.



## Contact

For questions or feedback, please contact:

- **Pranav T**
- Email: [pranavt96@example.com](mailto:pranavt96@example.com)
- GitHub: [PranavT96](https://github.com/PranavT96)
