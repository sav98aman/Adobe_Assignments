# Blog Application

I have developed this REST API for an Blog Application. This API performs all the fundamental CRUD operations of any Blog Application with user validation at every step.



## Installation & Run all End Point see on the Swagger -url after run the project on localMachine or Computer

run this command in your local Machine or PC
```bash
  git clone https://github.com/sav98aman/Adobe_Assignments.git
```

Before running the API server, you should update the database config inside the application.properties file.
Update the port number, username and password as per your local database config.


```
    server.port=8080

    spring.datasource.url=jdbc:mysql://localhost:3306/ADOBE;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```

## API Root Endpoint-- after Start the Server need to call this url u can see all the end point 

`http://localhost:8888/swagger-ui/index.html`




## API Module Endpoints

### User Module


* `POST /users` : Register ( Create new Account ) 
* `PUT /users/{user_id}` : Update the User name and Bio by `user_id`
* `DELETE /users/{user_id}` : Delete User by `user_id`
* `GET /users/{user_id}` : Getting a particular User Details by `user_id`
* `GET /analytics/users` : Getting total number of User
* `GET /analytics/users/top-active` 5 Top Active Users



### Post Module

* `POST /posts` : Create a new Post 
* `PUT /posts/{post_id}` : Update the Content by `post_id`
* `DELETE /posts/{post_id}` : Delete a Post by `post_id`
* `POST /posts/{post_id}/like` :  Update a Like value by `post_id`
* `POST /posts/{post_id}/unlike` : Update a Like value by decreasing 1 by`post_id`
* `GET /posts/{post_id}` :  Getting a particular post by `post_id`
* `GET /analytics/posts` : Getting total number of Post
* `GET /analytics/posts/top-active` Top 5 Most liked Post

### Sample API Response
Request Body for User

```
{
    "userName":"amankumar",
    "email":"abc@gmail.com",
    "bio":"Hello Ji i am Aman Kumar verma",
    "password":"1234"
}

```
Response Body

```
{
    "data": {
        "status": null,
        "data": {
            "userID": 2,
            "userName": "amankumar",
            "email": "abc@gmail.com",
            "bio": "Hello Ji i am Aman Kumar verma",
            "createAtTime": "2023-04-10T02:17:39.6623672",
            "updateAtTime": null
        }
    },
    "StatusCode": "OK",
    "status": "success"
}
```
