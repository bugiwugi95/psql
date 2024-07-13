package org.example.old;

import com.mongodb.client.MongoClients;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.function.Consumer;

//docker run -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=123w123 -e POSTGRES_USER=postgres  -d postgres
//docker run -p 27017:27017 --name smongo -d mongo
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try (var mongoClient = MongoClients.create()) {
            mongoClient.listDatabases()
                    .forEach((Consumer<Document>) System.out::println);
            // show dbs
            // Document{{name=test, sizeOnDisk=1.385336832E9, empty=false}}
            mongoClient.listDatabaseNames()
                    .forEach((Consumer<String>) System.out::println);
            // test
            var database = mongoClient.getDatabase("test");
            database.listCollectionNames()
                    .forEach((Consumer<String>) System.out::println);
            // todo
            database.listCollections()
                    .forEach((Consumer<Document>) System.out::println);


            var todoCollection = database.getCollection("todo");
            todoCollection.find(new Document("task", new Document("$regex", "coffee")))
                    .forEach((Consumer<Document>) System.out::println);



            var todoDocument = new Document(Map.of("_id", new ObjectId(),
                    "task", "Drink some coffee", "dateCreated", LocalDateTime.now(),
                    "done", false));

            todoCollection.insertOne(todoDocument);
        }
    }
}