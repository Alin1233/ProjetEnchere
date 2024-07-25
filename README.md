![image](https://github.com/user-attachments/assets/a525fcf8-a49b-413e-963a-2d08ce9a0d1f)# Project Enchère

This is a bidding web application similar to eBay, developed as part of a team project during my training. It leverages Java SE and JSPs with HTML, CSS, Bootstrap, Apache Tomcat, and SQL Server as the database.

## Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [Demonstration](#demonstration)
4. [Getting Started](#getting-started)
5. [Architecture](#architecture)
6. [Technologies Used](#technologies-used)
7. [Project Status](#project-status)
8. [Contributions](#contributions)
9. [License](#license)
10. [Contact Information](#contact-information)

## Introduction

Project Enchère is designed to replicate the core functionalities of a bidding platform like eBay. This project was created as a part of my training program, in collaboration with a team, to apply and enhance our web development skills. It provides users with an interactive and user-friendly environment to list items, place bids, and manage auctions.

## Features

- User registration and authentication
- Item listing with detailed descriptions and images
- Detailed filtering system

## Demonstration

![Screenshot](https://github.com/Alin1233/ProjetEnchere/blob/main/screenshots/Home%20Page.jpg?raw=true)
![Screenshot](https://github.com/Alin1233/ProjetEnchere/blob/main/screenshots/New%20Auction.jpg?raw=true)
![Screenshot](https://github.com/Alin1233/ProjetEnchere/blob/main/screenshots/Sign%20Up.jpg?raw=true)



## Getting Started

### Prerequisites

- Web browser (e.g., Chrome, Firefox)
- Java SE Development Kit (JDK)
- Apache Tomcat Server
- SQL Server

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/project-enchere.git
    ```
2. Navigate to the project directory:
    ```bash
    cd project-enchere
    ```
3. Set up the database:
    - Install SQL Server and create a database named `enchere_db`.
    - Run the SQL scripts provided in the `Scripts SQL` folder to set up the database schema.

4. Configure Tomcat:
    - Copy the project files to the `webapps` directory of your Apache Tomcat installation.
    - Ensure Tomcat is configured to connect to your SQL Server database with the appropriate JDBC driver.

5. Build and Run:
    - Compile the Java source files:
    ```bash
    javac -d WEB-INF/classes src/**/*.java
    ```
    - Package the application as a WAR file:
    ```bash
    jar -cvf project-enchere.war *
    ```
    - Deploy the WAR file to the Apache Tomcat server.

6. Start the Tomcat server and access the application at `http://localhost:8080/project-enchere`.

### Usage

After starting the development server, open your web browser and navigate to `http://localhost:8080/project-enchere` to access Project Enchère. Register an account or log in to start bidding on items.

## Architecture

Project Enchère is structured with a front-end and a back-end to manage different aspects of the application.

### Diagrams

![Flowchart]([link-to-flowchart.png](https://github.com/Alin1233/ProjetEnchere/blob/main/screenshots/image.png?raw=true))
![Flowchart](https://github.com/Alin1233/ProjetEnchere/blob/main/screenshots/Bidding%20Diagram.png?raw=true)

## Technologies Used

- **Languages**: Java SE, HTML, CSS
- **Frameworks**: JSP, Bootstrap
- **Server**: Apache Tomcat
- **Database**: SQL Server

## Project Status

Project Enchère is currently not complete with all core features implemented. Future improvements may include enhanced user profiles, finishing the bidding system, and integration with payment gateways.

## Contributions

### Acknowledgements

This project was developed in collaboration with my training team. Special thanks to all team members for their dedication and hard work.

### Contributing Guidelines

If you wish to contribute to Project Enchère, please follow these guidelines:
1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Submit a pull request with a detailed description of your changes.

## License

This project is licensed under the MIT License.

## Contact Information

For any inquiries, please contact [Your Name](mailto:herciualin10@gmail.com) or connect with me on [LinkedIn](https://linkedin.com/in/alin-herciu-22a550284/).
