package iki.fadhila.back_end.repository;

import iki.fadhila.back_end.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Long> {
    @Query("Select j from Job j")
    List<Job> getAllJobs();
}
