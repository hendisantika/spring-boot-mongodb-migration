package id.my.hendisantika.mongodbmigration.repository;

import id.my.hendisantika.mongodbmigration.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mongodb-migration
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/12/24
 * Time: 12.11
 * To change this template use File | Settings | File Templates.
 */
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
