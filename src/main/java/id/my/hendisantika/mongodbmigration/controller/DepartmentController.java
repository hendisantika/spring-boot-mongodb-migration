package id.my.hendisantika.mongodbmigration.controller;

import id.my.hendisantika.mongodbmigration.repository.DepartmentRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mongodb-migration
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/12/24
 * Time: 12.21
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
@Tag(name = "Department", description = "Department CRUD API with documentation annotations")
public class DepartmentController {
    private final DepartmentRepository departmentRepository;
}
