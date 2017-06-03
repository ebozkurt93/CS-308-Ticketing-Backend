# Ticket and Reservation System Services

- To clean build system from source code and to generate a `jar` file use the command `mvn clean install -Dmaven.test.skip=true package`. Package will be generated in `/target/` inside project folder.

- To run jar file use command `java -jar -Dfile.encoding=UTF-8 target/app.jar`, assuming jar file is located in `/target/` and named as `app.jar`

- If you want automatic database creation at runtime (system assumes you already created schema with name `test2`), in `resources/application.properties` change `spring.jpa.hibernate.ddl-auto=none` with `spring.jpa.hibernate.ddl-auto=create`

- Default database connection properties are set as written below
```
spring.datasource.url= jdbc:mysql://localhost:3306/test2?useUnicode=yes&characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=
```

- Any service call which contains `/secure/` requires `JWT Token`.

- An example `JWT` for this system contains `USER`'s role, email address, token creation and expiration datetime.

- JWT example = `eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhYkBhLmNvbSIsInJvbGVzIjpbIlVTRVIiXSwiaWF0IjoxNDk2MzM0NzI4LCJleHAiOjE0OTYzNTYzMjh9.6hqvcfQXJLe7zR5bXdGYiH78wc9SusAgnXxiqk18VOc` carries payload
```JSON
{
  "sub": "ab@a.com",
  "roles": [
    "USER"
  ],
  "iat": 1496334728,
  "exp": 1496356328
}
```


## User

**Method:**GET
http://localhost:8080/user/hello
*use to check if server is alive*

---

### For all users:

**Method:** POST
http://localhost:8080/user/register

```JSON
{
	"name":"name of user",
	"surname":"surname of user",
	"password":" password",
	"mail":"email@email.com",
	"address":"address of user"
}
```

---

**Method:** POST
http://localhost:8080/user/login

```JSON
{
  "mail":"email@email.com",
	"password":" password"
}
```

*Returns jwt(JSON Web Token) **Authentication Token**

---

### For admins:

**Method:** GET
http://localhost:8080/user/secure/getallusers

***Requires jwt***

---

**Method:** POST
http://localhost:8080/user/secure/addadminbyemail
```JSON
{
  "mail":"email@email.com"
}
```
***Requires jwt***

---

**Method:** POST
http://localhost:8080/user/secure/removeadminbyemail
```JSON
{
  "mail":"email@email.com"
}
```
***Requires jwt***

You cannot remove your admin role

---

## Event


### For users:


**Method:** GET
http://localhost:8080/event/getallevents

Returns all events as a JSON Array

---

**Method:** POST
http://localhost:8080/event/getcategories

Requires a JSON with `event_id`(Can also send more information, but id is more than enough)

```JSON
{
	"id":"1"
}
```

---

### For admins:


**Method:** POST
http://localhost:8080/event/secure/add
```JSON
{
	"name":"event name",
	"info":"event info",
	"actor":"event actor",
	"imageUrl1":"url1",
	"imageUrl2":"url2",
	"videoUrl":"url3",
	"categories":[
		{
			"startSeat":"1",
			"endSeat":"20",
			"name":"VIP",
			"price":"100"
		},
		{
			"startSeat":"21",
			"endSeat":"40",
			"name":"Economy",
			"price":"60"
		}
		]
}
```

***Requires jwt***

---

**Method:** POST
http://localhost:8080/event/secure/remove
```JSON
{
	"id":"1"
}
```

***Requires jwt***

---

## Ticket

- Careful with the upper/lower case here in links, for example `createticket != createTicket`

### For users:

**Method:** POST
http://localhost:8080/ticket/secure/createTicket



```JSON
{
	"seatname":"33",
	"category":{
		"id":"1"
	},
	"user": {
		"id":"3"
		}
}
```

***Requires jwt***

---

**Method:** POST
http://localhost:8080/ticket/secure/getAllTicketsForUser

```JSON
{
"id":"1"
}
```

- One very important detail, only an `USER` can see a ticket, and tickets can be seen only if `JWT` identity matches with `USER`'s id  who is trying to see tickets.

***Requires jwt***

---

**Method:** POST
http://localhost:8080/ticket/secure/getAllTicketsForEvent

```JSON
{
"id":"1"
}
```

***Requires jwt***

---

### For admins:


**Method:** POST
http://localhost:8080/ticket/secure/getAllTicketsForUserAsAdmin

- Requires `user_id` in JSON

```JSON
{
"id":"1"
}
```

***Requires jwt***

---

**Method:** POST
http://localhost:8080/ticket/secure/getAllTickets

***Requires jwt***

---

**Method:** POST
http://localhost:8080/ticket/secure/getTicket

- Requires `ticket_id` in JSON

```JSON
{
"id":"1"
}
```

***Requires jwt***
