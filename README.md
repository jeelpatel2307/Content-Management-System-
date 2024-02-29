# Content Management System (CMS)

This is a simple Content Management System (CMS) built with Java and Spring Boot.

## Overview

This CMS allows users to manage articles, including creating, reading, updating, and deleting them. It provides basic authentication functionality for user login.

## Features

- User authentication: Users can sign in to the system.
- Article management: Users can create, read, update, and delete articles.
- Database storage: Articles are stored in a MySQL database.
- RESTful API: CRUD operations are exposed via a RESTful API for easy integration with other systems.

## Technologies Used

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL

## Setup

1. Clone the repository:
    
    ```
    git clone <https://github.com/yourusername/cms.git>
    
    ```
    
2. Navigate to the project directory:
    
    ```
    cd cms
    
    ```
    
3. Build the project:
    
    ```
    mvn clean install
    
    ```
    
4. Run the application:
    
    ```
    java -jar target/cms.jar
    
    ```
    
5. Access the application at [http://localhost:8080](http://localhost:8080/)

## Usage

1. Sign in to the system using your username and password.
2. Navigate to the Articles section to manage articles.
3. Create, read, update, or delete articles as needed.

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

## Authors

- John Doe
- Jane Smith

## Acknowledgements

- Thanks to Spring Boot for providing a powerful framework for building Java applications.
- Special thanks to our contributors for their valuable contributions to this project.
