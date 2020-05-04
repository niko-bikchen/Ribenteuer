//developed by Vladyslav Haponenko
package com.scriptizergs.ribenteuer;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


//the class establishes connection to mongo db
@Configuration
@EnableMongoRepositories(basePackages = "com.scriptizergs.ribenteuer.model")
public class Config {


    //connection to database
    @Bean
    public static MongoClient mongo() {
        return new MongoClient(new MongoClientURI("mongodb://Vladyslav:Nikitabeliy2012@clusterfar-shard-00-00-7itsr.mongodb.net:27017,clusterfar-shard-00-01-7itsr.mongodb.net:27017,clusterfar-shard-00-02-7itsr.mongodb.net:27017/test?ssl=true&replicaSet=clusterfar-shard-0&authSource=admin&retryWrites=true&w=majority"));
    }

    //choosing db
    @Bean
    public static MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "rt");
    }
}
