package co.edu.cesde.recruitment.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateJpaRepo extends JpaRepository<CandidateJpaEntity, Long> {

}