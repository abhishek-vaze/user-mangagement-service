This microservice can be used in enterprise enviroment where multiple microservices are in service.
user-managment-service is a microservice which keeps the track of all users and its associated roles for an application
This service can be used to authorize and authenticate any user.
There are functional groups in the system
1. Application ->
   1.1 An application can be a microservice/traditional web app/enter prise app
   1.2 Application must be onboarded to UMS before assigning any user to it.
   1.3 Application is identified by ApplicationId within UMS but should have Global_Application_Id.
       In an Enterprise enviroment every application/system has a unique identifier which identifies the application
       uniqely at a global level. This id should be used here and should be populated by admin users or other systems.
   1.4 Application is onboarded by the admin users of UMS or you can modify the code to listen to a topic from which this info can be recieved.

2. User ->
   1.1 A user is a application user which has access to specific applications.
   1.2 UMS provides an api to authenticate the user for a specific application
   1.3 Once user is onboarded to UMS, roles of specific application are assigned to it.
   1.4 UMS provides and api which returns the user and its roles in an encrypted text called as Json Web Token.
   1.5 This JWT (Json web Token) can be used in other microservice/applications to authorize user.
   1.6 UMS provides another set of APIS which takes the JWT and validates its integrity. Other application can use this API to validate.

Admin UI
 This UI is used to perform some admin activities like
 1. Onboard an application and its roles
 2. Remove an application role
 2. Remove an applicaiton
 3. Assign a application roles a user.
 4. Unlock a user after many failed logins
 5. Remove a user.


