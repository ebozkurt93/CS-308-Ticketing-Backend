# Ticket and Reservation System Services

- Any service call which contains `/secure/` requires `JWT Token`.

## User

**Method:**GET
http://localhost:8080/user/hello
*use to check if server is alive*

---

### For all users:

**Method:** POST
http://localhost:8080/user/register

```
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

```
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
```
{
  "mail":"email@email.com"
}
```
***Requires jwt***

---

**Method:** POST
http://localhost:8080/user/secure/removeadminbyemail
```
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
---

### For admins:


**Method:** POST
http://localhost:8080/event/secure/add
```
{
	"name":"event name",
	"info":"event info",
	"actor":"event actor",
	"imageUrl1":"event imageurl1",
	"imageUrl2":"event imageurl2",
	"videoUrl":"event videourl"
}
```

***Requires jwt***

---

**Method:** POST
http://localhost:8080/event/secure/remove
```
{
	"id":"event id"
}
```

***Requires jwt***

---
