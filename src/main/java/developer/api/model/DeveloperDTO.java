package developer.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeveloperDTO {

    private Long id;
    private String name;
    private String seniority; //Perdaryti su string
    private LocalDate dob;
    private WorkplaceDTO workplaceDTO;
}
