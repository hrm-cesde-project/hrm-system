package co.edu.cesde.recruitment.controller;

import co.edu.cesde.recruitment.application.dto.*;
import co.edu.cesde.recruitment.application.port.input.CandidateServicePort;
import co.edu.cesde.recruitment.domain.enums.CandidateStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CandidateController.class)
class CandidateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private CandidateServicePort candidateServicePort;

    private static final String BASE_PATH = "/api/recruitment/candidates";

    @Test
    void createCandidate_shouldReturn201() throws Exception {
        CandidateCmd cmd = new CandidateCmd();
        cmd.setFirstName("Carlos");
        cmd.setLastName("Gomez");
        cmd.setEmail("carlos@example.com");
        cmd.setPhone("3001234567");
        cmd.setAppliedPosition("Developer");
        cmd.setApplicationDate(LocalDate.of(2026, 5, 24));

        CandidateDto dto = new CandidateDto(1L, "Carlos", "Gomez", "carlos@example.com",
                "3001234567", CandidateStatus.APPLIED, "Developer",
                LocalDate.of(2026, 5, 24), null);

        when(candidateServicePort.createCandidate(any())).thenReturn(dto);

        mockMvc.perform(post(BASE_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cmd)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("Carlos"))
                .andExpect(jsonPath("$.status").value("APPLIED"));
    }

    @Test
    void createCandidate_invalid_shouldReturn400() throws Exception {
        CandidateCmd cmd = new CandidateCmd();

        mockMvc.perform(post(BASE_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cmd)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getAllCandidates_shouldReturn200() throws Exception {
        CandidateDto dto = new CandidateDto(1L, "Ana", "Lopez", "ana@example.com",
                "3007654321", CandidateStatus.APPLIED, "Designer",
                LocalDate.of(2026, 5, 24), null);

        when(candidateServicePort.findAll()).thenReturn(List.of(dto));

        mockMvc.perform(get(BASE_PATH)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("Ana"));
    }

    @Test
    void getCandidateById_shouldReturn200() throws Exception {
        CandidateDto dto = new CandidateDto(1L, "Luis", "Martinez", "luis@example.com",
                "3001112233", CandidateStatus.SCREENING, "Analyst",
                LocalDate.of(2026, 5, 24), null);

        when(candidateServicePort.findById(1L)).thenReturn(dto);

        mockMvc.perform(get(BASE_PATH + "/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.status").value("SCREENING"));
    }

    @Test
    void getCandidateById_notFound_shouldReturn404() throws Exception {
        when(candidateServicePort.findById(99L))
                .thenThrow(new co.edu.cesde.recruitment.domain.exception.CandidateNotFoundException(99L));

        mockMvc.perform(get(BASE_PATH + "/{id}", 99L)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void advanceStatus_shouldReturn200() throws Exception {
        StatusRequest request = new StatusRequest();
        request.setAction(StatusRequest.StatusAction.ADVANCE);

        CandidateDto dto = new CandidateDto(1L, "Carlos", "Gomez", "carlos@example.com",
                "3001234567", CandidateStatus.SCREENING, "Developer",
                LocalDate.of(2026, 5, 24), null);

        when(candidateServicePort.advanceStatus(1L)).thenReturn(dto);

        mockMvc.perform(patch(BASE_PATH + "/{id}/status", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("SCREENING"));
    }

    @Test
    void rejectCandidate_shouldReturn200() throws Exception {
        StatusRequest request = new StatusRequest();
        request.setAction(StatusRequest.StatusAction.REJECT);
        request.setReason("Insufficient experience");

        CandidateDto dto = new CandidateDto(1L, "Carlos", "Gomez", "carlos@example.com",
                "3001234567", CandidateStatus.REJECTED, "Developer",
                LocalDate.of(2026, 5, 24), "Insufficient experience");

        when(candidateServicePort.reject(eq(1L), eq("Insufficient experience"))).thenReturn(dto);

        mockMvc.perform(patch(BASE_PATH + "/{id}/status", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("REJECTED"))
                .andExpect(jsonPath("$.rejectionReason").value("Insufficient experience"));
    }

    @Test
    void deleteCandidate_shouldReturn204() throws Exception {
        doNothing().when(candidateServicePort).deleteCandidate(1L);

        mockMvc.perform(delete(BASE_PATH + "/{id}", 1L))
                .andExpect(status().isNoContent());
    }

    @Test
    void exportCsv_shouldReturn200() throws Exception {
        byte[] csv = "id,first,last\n1,Carlos,Gomez\n".getBytes();
        when(candidateServicePort.exportCsv()).thenReturn(csv);

        mockMvc.perform(get(BASE_PATH + "/export/csv"))
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Disposition", "attachment; filename=\"candidates.csv\""))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_OCTET_STREAM));
    }

    @Test
    void getAnalytics_shouldReturn200() throws Exception {
        CandidateAnalyticsDto analytics = new CandidateAnalyticsDto(5, Map.of(
                "APPLIED", 2L,
                "SCREENING", 1L,
                "INTERVIEW", 1L,
                "HIRED", 1L,
                "REJECTED", 0L
        ));

        when(candidateServicePort.getAnalytics()).thenReturn(analytics);

        mockMvc.perform(get(BASE_PATH + "/analytics")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.total").value(5))
                .andExpect(jsonPath("$.byStatus.APPLIED").value(2));
    }
}
