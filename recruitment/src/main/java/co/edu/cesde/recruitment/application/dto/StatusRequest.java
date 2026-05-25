package co.edu.cesde.recruitment.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StatusRequest {

    @NotNull
    private StatusAction action;

    private String reason;

    public StatusAction getAction() { return action; }
    public void setAction(StatusAction action) { this.action = action; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public enum StatusAction {
        ADVANCE,
        REJECT
    }
}
