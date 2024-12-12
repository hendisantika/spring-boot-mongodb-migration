package id.my.hendisantika.mongodbmigration.domain;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mongodb-migration
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/12/24
 * Time: 12.07
 * To change this template use File | Settings | File Templates.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employee")
public class Employee {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private double salary;

    @NotNull
    private Department department;
}
