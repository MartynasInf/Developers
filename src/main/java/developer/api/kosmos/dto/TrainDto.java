package developer.api.kosmos.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * DTO class to hold train entity related data
 * Mostly will be used in REST requests/responses handling
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainDto {

    private Long id;
    private String name;
    private Integer capacity;
    private Integer yearCreated;
}
