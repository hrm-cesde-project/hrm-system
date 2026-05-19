package co.edu.cesde.recruitment.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resume {

    private Long id;
    private Long candidateId;
    private String filePath;
    private String fileUrl;

}
