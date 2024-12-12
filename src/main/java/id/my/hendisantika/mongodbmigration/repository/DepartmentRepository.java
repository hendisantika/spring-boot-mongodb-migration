package id.my.hendisantika.mongodbmigration.repository;

import id.my.hendisantika.mongodbmigration.domain.Department;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mongodb-migration
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/12/24
 * Time: 12.08
 * To change this template use File | Settings | File Templates.
 */
public interface DepartmentRepository extends MongoRepository<Department, String> {

    Optional<Department> findAllByCode(@NonNull String code);
}
