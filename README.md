# UpVotR App Developer Guide

About:
- This is a web app that lets you submit ideas and vote on other people's ideas
- It has two Roles: USER and ADMIN
  - USER: can submit new ideas, can upvote or downvote ideas
  - ADMIN: has to accept ideas before they are displayed to USERs, and can see the list of accepted ideas

Stack:
- PostGreSQL
- Spring Boot
- Angular

Backend:
- RESTful API
- Authentication with JWToken
- Endpoint documentation with Swagger
  - once the backend is running: http://localhost:8080/swagger-ui/index.html
- DB connection with JPA

Frontend:
- Styles exclusively with Bootstrap v5
- Has Routing
- Uses reactive forms only
- Json Webtoken is passed to backend via an interceptor, see: upvoter-frontend/src/utils/auth.interceptor.ts

How to run:
- You'll need
  - Java 17
  - Angular CLI 14
  - A PostGreSQL DB with a schema named 'upvoter' (modify application.yaml to fit your credentials)
  - npm (+node_modules installed)

Trying it out:
- I did not provide sql scripts for populating the db, because you can create your own accounts and content very easily
- For an admin account modify the role in the app_user table to ROLE_ADMIN. After logging in, you will have access to admin functionalities

Limitations:
- little to no validation and exception handling occurs as of this moment
- The token's signature key is in the source code for testing purposes / ease of use
- The app is not prepared for deployment whatsoever :)
