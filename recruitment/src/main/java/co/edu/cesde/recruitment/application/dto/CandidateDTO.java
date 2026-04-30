package co.edu.cesde.recruitment.application.dto;

import co.edu.cesde.recruitment.domain.enums.CandidateStatus;

import java.time.LocalDate;

public class CandidateDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private CandidateStatus status;
}
