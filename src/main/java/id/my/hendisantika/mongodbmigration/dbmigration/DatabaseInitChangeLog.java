package id.my.hendisantika.mongodbmigration.dbmigration;

import id.my.hendisantika.mongodbmigration.domain.Department;
import id.my.hendisantika.mongodbmigration.domain.Employee;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mongodb-migration
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/12/24
 * Time: 12.12
 * To change this template use File | Settings | File Templates.
 */
@ChangeUnit(id = "DB-init", order = "1", author = "bootlabs")
public class DatabaseInitChangeLog {

    private final MongoTemplate template;

    public DatabaseInitChangeLog(MongoTemplate template) {
        this.template = template;
    }

    @Execution
    public void execute() {
        // insert departments
        template.insertAll(initDepartments());

        // insert employees
        List<Employee> employees = Stream.concat(initHrEmployees().stream(), initRadEmployees().stream()).toList();
        template.insertAll(employees);
    }

    @RollbackExecution
    public void rollback() {
        template.remove(new Department());
        template.remove(new Employee());
    }

    private List<Department> initDepartments() {
        return Arrays.asList(
                Department.builder()
                        .name("Human Resource Management")
                        .code("HR")
                        .build(),
                Department.builder()
                        .code("R&D")
                        .name("Research and Development (often abbreviated to R&D)")
                        .build(),
                Department.builder()
                        .name("Prod")
                        .code("Production")
                        .build(),
                Department.builder()
                        .name("Sales")
                        .code("Sales")
                        .build(),
                Department.builder()
                        .name("Marketing")
                        .code("Marketing")
                        .build(),
                Department.builder()
                        .name("Finance")
                        .code("Finance")
                        .build()
        );
    }

    private List<Employee> initHrEmployees() {
        List<Employee> hrEmployees = new ArrayList<>();
        Optional<Department> hrDepartment = initDepartments().stream().filter(department -> department.getCode().equals("HR")).findFirst();

        if (hrDepartment.isPresent()) {
            hrEmployees.add(Employee.builder()
                    .firstName("Itadori")
                    .lastName("Yuji")
                    .email("yuji@yopmail.com")
                    .department(hrDepartment.get())
                    .build());

            hrEmployees.add(Employee.builder()
                    .firstName("Megumi")
                    .lastName("Fushiguro")
                    .email("megumi@yopmail.com")
                    .department(hrDepartment.get())
                    .build());
        }

        return hrEmployees;
    }

    private List<Employee> initRadEmployees() {
        List<Employee> radEmployees = new ArrayList<>();
        Optional<Department> radDepartment = initDepartments().stream().filter(department -> department.getCode().equals("R&D")).findFirst();

        radDepartment.ifPresent(department -> radEmployees.add(Employee.builder()
                .firstName("Naobara")
                .lastName("Kughisaki")
                .email("naobara@yopmail.com")
                .department(department)
                .build()));

        return radEmployees;
    }
}
