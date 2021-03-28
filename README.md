# eksidebeAPI 

> eksisozluk.con is one of the biggest social media websites in Turkey. It publishes the best posts of the prior's day 
for 24 hours. After this period these posts vanish.

This background service fetches the DEBE (Best posts of yesterday) via consuming REST GET requests with `date` information.
It consumes the data that fetched via [EksiDebeFetcher Service](https://github.com/dauut/EksiDebeFetcher). 

### This is the second service of an experimental `microservice` architecture.

## Requirements 
- Spring Boot
- PostgreSQL
- Java 8+
- Redis

## Project Structure
```
.eksidebeAPI/                       # eksisozluk.com best posts REST API
├── src                             # Source files 
|    ├── main
|    |    ├── java                
|    |    |    ├── dao                       # Data Access Object Pattern
|    |    |    ├── model                     # data models, objects
|    |    |    ├── service                   # main fetcher services
|    |    |    ├── utils                     # utility classes, configurations
|    |    ├── resources              # log4j, application.properties
├── logs                             # logs
└── README.md
```

## Usage

`hostaddress:8081/debe/{date}`

*Example:*

`http://localhost:8080/debe/2020-08-01`