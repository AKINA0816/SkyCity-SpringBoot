# SkyCity-SpringBoot
It's a entertainment community website.(Inspired by twitch). You can not only listening music on the website, but also live chat with other users in a chat room to share your thoughts.
Also, the website provide google map, weather forecast, free wallpaper to download.

## Requirements

1. Setup Mysql
```mysql
create database skycity;
use skycity;
create table t_user (
id int(10) auto_increment primary key,
name varchar(30) not null,
password varchar(30) not null
)
```


## Usage
1. Edit application.properties with your own database url, username and password
2. Run SkycityApplication Class 
3. Visit [http://localhost:8080/](http://localhost:8080/)


## Framework
- Front end: Bootstrap4.1+Thymeleaf
- Back end: SpringBoot+Mybatis+SpringSecurity+Netty(not now)

## Todo-list
### 1. For user 
- View & update personal info
- Live chat with other user
- Google map
- Weather forecast
- Calendar

### 2. For administrator

- Create, read, update and delete users


