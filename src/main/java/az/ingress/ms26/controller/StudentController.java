package az.ingress.ms26.controller;

import az.ingress.ms26.domain.SearchCriteria;
import az.ingress.ms26.domain.Student;
import az.ingress.ms26.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/v1/students")
@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;


    @GetMapping("/list")
    public List<Student> getListByCriteria(@RequestBody List<SearchCriteria> dto) {
        return studentService.getAllByCriteria(dto);
    }

}
