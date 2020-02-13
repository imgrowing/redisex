package my.sdr.redisex.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@RedisHash("students")
public class Student {

    @Id
    private Long studentId;

    private String name;

    @TimeToLive
    private int ttl;

    public Student() {
    }

    public Student(Long studentId, String name, int ttl) {
        this.studentId = studentId;
        this.name = name;
        this.ttl = ttl;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", ttl=" + ttl +
                '}';
    }
}
