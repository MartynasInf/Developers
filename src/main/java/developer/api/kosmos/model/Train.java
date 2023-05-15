package developer.api.kosmos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer capacity;
    private Integer yearCreated;

    public Train(String name, Integer capacity, Integer yearCreated) {
        this.name = name;
        this.capacity = capacity;
        this.yearCreated = yearCreated;
    }

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    private List<Destination> destinations;



}
