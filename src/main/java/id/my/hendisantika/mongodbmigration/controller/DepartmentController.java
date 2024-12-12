package id.my.hendisantika.mongodbmigration.controller;

import id.my.hendisantika.mongodbmigration.domain.Department;
import id.my.hendisantika.mongodbmigration.repository.DepartmentRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
 * Time: 12.21
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
@Tag(name = "Department", description = "Department CRUD API with documentation annotations")
public class DepartmentController {
    private final DepartmentRepository departmentRepository;

    @GetMapping()
    @Operation(summary = "Get All Cars")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Saved superheroes list"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<List<Department>> getAllDepartments() {
        return new ResponseEntity<>(departmentRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    @Operation(summary = "Add New Department")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Saved superheroes list"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        return new ResponseEntity<>(departmentRepository.save(department), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Department by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Saved superheroes list"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") String id) {
        return new ResponseEntity<>(departmentRepository.findById(id).get(), HttpStatus.OK);
    }
}
