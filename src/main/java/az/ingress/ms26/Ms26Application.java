package az.ingress.ms26;

import az.ingress.ms26.domain.Student;
import az.ingress.ms26.repostiory.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Ms26Application implements CommandLineRunner {
    private final StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Ms26Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student a1 = Student.builder()
                .id(3L)
                .firstName("Elgun1")
                .lastName("Mahmudov2")
                .age(31)
                .studentNumber("AA121324")
                .build();
        studentRepository.save(a1);

        Student a2 = Student.builder()
                .id(3L)
                .firstName("Kanan")
                .lastName("Majid")
                .age(19)
                .studentNumber("AA121324")
                .build();
        studentRepository.save(a2);

        Student a3 = Student.builder()
                .id(4L)
                .firstName("Elgun")
                .lastName("Grandeur")
                .age(33)
                .studentNumber("AA121314")
                .build();
        studentRepository.save(a3);
    }
}
