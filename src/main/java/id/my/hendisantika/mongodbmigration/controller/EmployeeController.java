package id.my.hendisantika.mongodbmigration.controller;

import id.my.hendisantika.mongodbmigration.domain.Employee;
import id.my.hendisantika.mongodbmigration.repository.EmployeeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mongodb-migration
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/12/24
 * Time: 12.38
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
@Tag(name = "Employee", description = "Employee CRUD API with documentation annotations")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    @GetMapping()
    @Operation(summary = "Get All Employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Saved superheroes list"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    @Operation(summary = "Add New Employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Saved superheroes list"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Employee by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Saved superheroes list"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id) {
        return new ResponseEntity<>(employeeRepository.findById(id).get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Employee by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Saved superheroes list"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") String id, @RequestBody Employee employee) {
        if (employeeRepository.existsById(id)) {
            return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.ACCEPTED);
        }

        throw new IllegalArgumentException("Car with id " + id + "not found");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Employee by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Saved superheroes list"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") String id) {
        employeeRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
