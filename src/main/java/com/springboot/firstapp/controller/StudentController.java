package com.springboot.firstapp.controller;

import com.springboot.firstapp.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    //http://localhost:8080/student
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1L, "Juan", "Perez");
        //return new ResponseEntity(student, HttpStatus.OK);
        //return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("Custom-header","Juan").body(student);
    }

    //Esto es posible debido  a la libreria Jackson que se encuentra en el pom.xml y es la que se encarga de convertir el objeto a JSON
    //Jackson es una libreria de serializacion y deserializacion de JSON incluida en Spring Boot

    //http://localhost:8080/students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L, "Juan", "Perez"));
        students.add(new Student(2L, "Maria", "Gomez"));
        students.add(new Student(3L, "Pedro", "Gonzalez"));
        return ResponseEntity.ok(students);
    }

    //Springboot REST API with Path Variable
    //{id} - URI Template Variable
    //{first-name} - URI Template Variable
    //{last-name} - URI Template Variable
    //http://localhost:8080/student/16/Manolo/Perez
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long studentId, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName){
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    //Springboot REST API with Request Parameter
    //http://localhost:8080/student/query?id=1&firstName=Sergio&lastName=Ramos
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestvariable(@RequestParam Long id, @RequestParam String firstName, @RequestParam String lastName){
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    //Springboot REST API that handles HTTP POST Request
    //@RequestBody - Springboot will convert the JSON request body into Java object
    //@PostMapping - HTTP POST Request - used to create an student
    @PostMapping("create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //@PutMapping - HTTP PUT Request - used to update an student
    @PutMapping("update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student){
        System.out.println(id);
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    //@DeleteMapping - HTTP DELETE Request - used to delete an student
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        System.out.println("Se borro de la base de datos el estudiante con id: " + id);
        return ResponseEntity.ok("Se borro exitosamente el id: " + id);
    }

}
