package co.edu.cesde.recruitment.infrastructure.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "candidates")
public class CandidateJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;

}