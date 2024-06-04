package comchunjae.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

//@Entity
@Table(name="userjob")
@Getter @Setter
public class UserJob {
    @Id
    @Column(name="job_id",length = 10)
    private String jobId;
    @Column(name="job_title",length = 35, nullable = false)
    private String jobTitle;
    @Column(name="min_salary",precision = 8, scale = 0)
    private BigDecimal minSalary;
    @Column(name="max_salary",precision = 8,scale = 0)
    private BigDecimal maxSalary;
}
