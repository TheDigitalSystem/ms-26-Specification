package az.ingress.ms26.repostiory;

import az.ingress.ms26.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentRepository extends JpaRepository<Student, Long> , JpaSpecificationExecutor<Student> {
}
