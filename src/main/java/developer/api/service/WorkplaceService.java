package developer.api.service;

import developer.api.model.Workplace;
import developer.api.model.WorkplaceDTO;
import developer.api.repository.WorkplaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkplaceService {

    private final WorkplaceRepository workplaceRepository;

    public List<Workplace> findAllWorkplaces(){
        return workplaceRepository.findAll();
    }

    public List<Workplace> addNewWorkplace(WorkplaceDTO workplaceDTO){
        Workplace workplace = Workplace.builder()
                .name(workplaceDTO.getName())
                .address(workplaceDTO.getAddress())
                .build();
        workplaceRepository.save(workplace);
        return workplaceRepository.findAll();
    }
}
