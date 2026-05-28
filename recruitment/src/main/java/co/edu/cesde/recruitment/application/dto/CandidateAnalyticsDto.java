package co.edu.cesde.recruitment.application.dto;

import java.util.Map;

public class CandidateAnalyticsDto {

    private long total;
    private Map<String, Long> byStatus;

    public CandidateAnalyticsDto(long total, Map<String, Long> byStatus) {
        this.total = total;
        this.byStatus = byStatus;
    }

    public long getTotal() { return total; }
    public Map<String, Long> getByStatus() { return byStatus; }
}
