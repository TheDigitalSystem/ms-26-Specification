package az.ingress.ms26.service;

import az.ingress.ms26.domain.SearchCriteria;
import az.ingress.ms26.domain.Student;
import az.ingress.ms26.domain.StudentSpecification;
import az.ingress.ms26.repostiory.StudentRepository;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    // private final ModelMapper modelMapper;

    List<Student> getAllBy() {
        return studentRepository.findAll(ageGreaterThan(20));
    }

    public List<Student> getAllByName(){
        return studentRepository.findAll(Specification.where(nameLike("Az")).and(ageGreaterThan(20))); //Dynamic Query

    } // Axtarisha Az verende Azerqaz, AzerSu, AzerIshiq hamisi cixardir

//    public List<Student> gpaGreaterThan91(){
//        return studentRepository.findAll(gpaGreaterThan(91.0));
//        Mail mail = new Mail;
//        System.out.println("Salam" + user );
//    }
    public List<Student> getAllByCriteria(List<SearchCriteria> dto) {
        StudentSpecification studentSpecification = new StudentSpecification();
        dto.forEach(studentSpecification::add); // bu ise 2ci variant Lambda ile yazmaq usulu
        //dto.forEach(searchCriteria -> studentSpecification.and(searchCriteria)); // bu 1ci variant. Eeger cetin gelse kec 2ci varianta
        return studentRepository.findAll(studentSpecification);
    }


    private Specification<Student> ageGreaterThan(int age) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get(Student.Fields.age), age));
    }

    private Specification<Student> nameLike(String firstName) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Student.Fields.firstName), firstName));
    }
    private  Specification<Student> gpaGreaterThan(double gpa){
       return  ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get(Student.Fields.gpa),gpa));
    }
}


//    public List<Student> findAllStudents() {
//        List<Student> students = studentRepository.findAll();
//        return students.stream()
//                .map(student -> modelMapper.map(student, Student.class))
//                .collect(Collectors.toList());
//    }

//    public Specification<Student> getUsers(String firstName, String lastName) {
//        Specification<Student> studentSpecification = (root, query, criteriaBuilder) -> {
//            Predicate firstNamePred = criteriaBuilder.equal(root.get("firstName"), firstName);
//            Predicate lastNamePred = criteriaBuilder.equal(root.get("lastName"), lastName);
//            return criteriaBuilder.and(firstNamePred, lastNamePred);
//            // butun seniorlar bunu Copy . Paste edir ay yaziq
//
//        };
//
//}
