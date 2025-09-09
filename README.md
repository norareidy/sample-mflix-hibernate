# Get Started with MongoDB Hibernate Extension

Learn how to create a basic application that connects the Hibernate ODM
to MongoDB.

You can follow the steps below or clone this sample app.

## Prerequisites

- Java 17+
- Maven 3.9+
- IDE, such as IntelliJ or Eclipse

## 1: Install mongo-hibernate

1. Clone the `mongo-hibernate` repository:

    ```
    git clone https://github.com/mongodb/mongo-hibernate.git
    ```
2. Navigate to the `mongo-hibernate` folder and publish to your local Maven repository:

   ```
   cd mongo-hibernate
   ./gradlew publishToMavenLocal
   ```

## 2: Create a Maven or Gradle project

In your IDE, create a Maven or Gradle Java project.
If you're using Maven, add the following dependency to your
`pom.xml` file:

```
<dependency>
   <groupId>org.mongodb</groupId>
   <artifactId>mongodb-hibernate</artifactId>
   <version>1.0.0-SNAPSHOT</version>
</dependency>
```

If you're using Gradle, add the following dependency to
your `build.gradle` file:

```
dependencies {
    implementation 'org.mongodb:mongodb-hibernate:1.0.0-SNAPSHOT'
}
```

*Note*: This sample app uses Maven and defines a `pom.xml` file.

## 3: Configure your MongoDB connection

1. Create a `hibernate.cfg.xml` file in your project's `resources` folder.
   Use the `hibernate.cfg.xml` file in this sample app as a template
   and copy its contents.

2. Replace the `connection-string` placeholder with your MongoDB Atlas connection string.

   Ensure that you specify the `sample_mflix` database in the connection string by
   using this syntax:

   ```
   mongodb+srv://<username>:<password>@<cluster>/sample_mflix?<options>
   ```

## 4: Create your application files

1. Navigate to `src/main`. Create a `HibernateUtil.java` file in your package directory.

   This utility class creates a `SessionFactory` based on your `hibernate.cfg.xml`
   configuration file. Copy the contents of this sample app's `HibernateUtil.java` file.

2. Create a `Movie.java` file in your package directory.

   This file defines your `Movie` entity class, which represents the `sample_mflix.movies`
   sample collection. Copy the contents of this sample app's `Movie.java` file.

2. Edit your `Main.java` file to interact with the database.

   This file runs CRUD operations on the `movies` collection. Copy the contents of this sample
   app's `Main.java` file.

## 5: Run the application

1. Run the `Main.java` file in your IDE. Your output should resemble the following:

   ```
   Title: Little Women, Year: 1949
   Title: Little Women, Year: 1994
   Movie created with id: 68bb32330b52ef3febf7d582
   Movie updated with new cast member: Jennifer Grey
   Movie deleted with id: 68bb32330b52ef3febf7d582
   ```