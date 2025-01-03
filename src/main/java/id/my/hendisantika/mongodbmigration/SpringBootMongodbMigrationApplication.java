package id.my.hendisantika.mongodbmigration;

import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongock
public class SpringBootMongodbMigrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongodbMigrationApplication.class, args);
    }

}
