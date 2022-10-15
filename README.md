## **CRUD Kanban Board Web Application Demo**

**Actual stand:**
- The app can only be running locally.
- REST API for CRUD is complete although in the Frontend you can only find the form for creating cards
- Interface for presenting the cardboard needs to be overwritten
- Authentication system is missing
- Tests in Backend need to be overwritten

**How to run the project:**

Start Backend: Run src\main\java\com\example\spring_react_auth_crud_demo\SpringReactAuthCrudDemoApplication.java

Start Frontend: Go to frontend-react\ and type in console `npm install` to install all needed dependencies and then type `npm start` (Node.js >= v14.0.0 and npm >= 5.6 are needed)

**What is used:**
- Spring boot 2.7.2 on Java 17 (Backend)
- React (Frontend)

**Backend dependencies:**
- Rest Repositories (Exposing Spring Data repositories over REST via Spring Data REST)
- JPA (Persist data in SQL stores with Java persistence API using Spring Data and Hibernate)
- H2 Database (Fast in-memory database)
- Assertj (For convenient tests)

**Frontend dependencies:**
- Bootstrap (`npm install react-bootstrap bootstrap`)
- Axios (`npm install axios`)
- react-router-dom (`npm install react-router-dom`)

**Additional Tools:**
- Maven 3.8.6
- Node.js v16.17.0 (includes npm 8.15.0)
- NVM 1.1.9 (Node Version Manager - POSIX-compliant bash script to manage multiple active node.js versions)

**Project Environment:**
- Project SDK: openjdk-17 (java version "17")
- Project language level: 17 - Sealed types, always-strict floating-point semantics