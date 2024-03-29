EstatePro Spring Boot GraphQL project
=====

This repository is an example application for the [Spring Boot framework](https://spring.io/projects/spring-boot) that employs the Netflix [DGS framework](https://netflix.github.io/dgs) to expose a GraphQL API and that interacts with a [PostgreSQL DBMS](https://www.postgresql.org/) via [Spring Data JPA](https://spring.io/projects/spring-data-jpa). 

It shows the following features:
* Datafetchers
* Mutations
* DataLoader to prevent the N+1 problem
* Lombok for model classes
* Spring Data JPA

Other examples
---

There are other examples of using the DGS framework as well:
- [Java DGS Framework example](https://github.com/Netflix/dgs-examples-java)
- [Kotlin DGS Framework example](https://github.com/Netflix/dgs-examples-kotlin)
- [Federation examples (with Apollo Gateway)](https://github.com/Netflix/dgs-federation-example)


Agencies, Agents, and Properties
----

This example is built around three main types: Agencies, Agents, and Properties. Each real estate agency has an ID, a name, a tax code, and is associated with N agents and N properties. A real estate agent has a UUID, a full name and is associated with only one agency. Each property has an ID, a name, a type (enumeration), coordinates, a purchase date and is associated with only one real estate agency. A property can be created, updated or deleted using a mutation.


The schema file is located in the following path.
```sh
/src/main/resources/schema/schema.graphql
```

Starting the example
----

The example requires Java 17 and PostgreSQL 14.

Create a PostgreSQL database, using the database name, username, and password contained in `application.yml`. 

Run the application in an IDE using its main class or using Gradle: 

```
./gradlew bootRun
```

Interact with the application using GraphiQL on http://localhost:8081/graphiql.

