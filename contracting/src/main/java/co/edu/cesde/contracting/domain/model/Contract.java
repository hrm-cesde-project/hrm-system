package co.edu.cesde.contracting.domain.model;

import co.edu.cesde.contracting.domain.enums.contractStatus;
import co.edu.cesde.contracting.domain.enums.contractType;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
public class Contract {
    private Long id;
    private Long employeeId;
    private contractType type;
    private BigDecimal salary;
    private LocalDate startDate;
    private LocalDate endDate;
    private contractStatus status;
    private String terminationReason;

    public boolean isCurrent(){
        return this.status == contractStatus.VALID;
    }
    public long daysRemaining(){
       if (endDate == null) return Long.MAX_VALUE;
       return ChronoUnit.DAYS.between(LocalDate.now(), endDate);
    }
    public void finish(String reason){
        this.status = contractStatus.EXPIRED;
        this.terminationReason = reason;
        this.endDate = LocalDate.now();
    }

    public BigDecimal getSalaryBase() { return salary;}
}
