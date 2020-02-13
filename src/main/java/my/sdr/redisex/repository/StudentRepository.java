package my.sdr.redisex.repository;

import my.sdr.redisex.dto.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
