package co.edu.cesde.recruitment.repository;

import co.edu.cesde.recruitment.domain.enums.CandidateStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateJpaRepository extends JpaRepository<CandidateEntity, Long> {

    List<CandidateEntity> findByStatus(CandidateStatus status);
}
