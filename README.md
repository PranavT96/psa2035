# PSA2035 Project

Welcome to the **PSA2035** project repository! This project serves as a comprehensive solution for managing and tracking activities, designed with scalability and efficiency in mind.

## Features

- **User Management**: Create, update, and manage user accounts.
- **Data Analysis**: Tools for visualizing and analyzing key metrics.
- **Report Generation**: Generate and export detailed reports.
- **Scalable Design**: Optimized for performance and easy to scale.
- **API Testing**: Endpoints tested using Postman.

## Technologies Used

- **Frontend**: HTML, CSS, JavaScript
- **Backend**: Java, Servlets, JSP
- **Database**: MySQL
- **Frameworks**: Hibernate, Spring (if applicable)
- **Tools**: Postman (for API testing)
- **Version Control**: Git

## Prerequisites

Ensure you have the following installed:

- Java Development Kit (JDK) 8 or later
- Apache Tomcat 9.0 or later
- MySQL 5.7 or later
- Maven (for dependency management)
- Git (for cloning the repository)
- Postman (for API testing)

## Getting Started

1. **Clone the Repository**

   ```bash
   git clone https://github.com/PranavT96/psa2035.git
   ```

2. **Import the Project**

   - Open your IDE (e.g., IntelliJ IDEA or Eclipse).
   - Import the project as a Maven project.

3. **Set Up the Database**

   - Create a MySQL database named `psa2035`.
   - Run the provided SQL script (`/db/schema.sql`) to set up the tables.
   - Update the `db.properties` file with your database credentials.

4. **Deploy to Tomcat**

   - Build the project using Maven:

     ```bash
     mvn clean install
     ```

   - Deploy the generated `.war` file to the `webapps` directory of your Tomcat server.

5. **Run the Application**

   - Start the Tomcat server.
   - Access the application at: `http://localhost:8080/psa2035`

6. **Test APIs with Postman**

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

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.

## Contact

For questions or feedback, please contact:

- **Pranav T**
- Email: [pranavt96@example.com](mailto:pranavt96@example.com)
- GitHub: [PranavT96](https://github.com/PranavT96)
