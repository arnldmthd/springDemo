<div align="center">

  <img width="200px" src="https://qph.fs.quoracdn.net/main-qimg-8d71d8588b76fbb0cc5cdec3be420d63" />

### Demo

</div>

## Docs

- [Story](#story)
- [Links to code](#links-to-code)

## Story

1) Spring Boot microservice
https://spring.io/guides/gs/spring-boot/

2) Using Maven
https://spring.io/guides/gs/maven/

3) Source in public Git-repository

4) Unit test due to Business Logic

5) IntelliJ IDEA ( https://www.jetbrains.com/idea/download/#section=windows ) 

6) Get data from
* https://restcountries.eu/
* https://restcountries.eu/rest/v2/all
* https://restcountries.eu/rest/v2/alpha/fi

7) Desired endpoints
```
GET /country_codes
response:
{ “country_codes” : [“AF”, “AX”, “AL”, ….] }

## GET /capital/[country_code]
response:
{  “name” : “Finland”, “capital” : “Helsinki” }
```

## Links To Code

[Application](https://github.com/arnldmthd/springDemo/tree/master/src/main/java/com/springDemo)  

[Tests](https://github.com/arnldmthd/springDemo/tree/master/src/test/java/com/springDemo)
