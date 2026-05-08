package co.edu.cesde.recruitment.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CandidateCmd {
    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    private String phone;

}
