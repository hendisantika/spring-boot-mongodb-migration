package id.my.hendisantika.mongodbmigration.dbmigration;

import id.my.hendisantika.mongodbmigration.domain.Employee;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mongodb-migration
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/12/24
 * Time: 12.16
 * To change this template use File | Settings | File Templates.
 */
@ChangeUnit(id = "DB-update", order = "2", author = "bootlabs")
public class DatabaseUpdateChangeLog {

    private final MongoTemplate template;

    public DatabaseUpdateChangeLog(MongoTemplate template) {
        this.template = template;
    }

    @Execution
    public void updateEmployees() {
        template.findAll(Employee.class).forEach(employee -> {
            employee.setSalary(100.0);
            template.save(employee);
        });
    }
}
