package co.edu.cesde.recruitment.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobPositionRef {

    private Long id;
    private String title;
    private String description;

}
