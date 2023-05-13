package developer.api.service;

import developer.api.model.Developer;
import developer.api.model.DeveloperDTO;
import developer.api.model.Workplace;
import developer.api.repository.DeveloperRepository;
import developer.api.repository.WorkplaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DeveloperService {
    private final DeveloperRepository developerRepository;
    private final WorkplaceRepository workplaceRepository;
    private final WorkplaceService workplaceService;

    public List<Developer> findAllDevelopers(){
        return developerRepository.findAll();
    }
    public Developer saveDeveloper(DeveloperDTO developerDTO){
        List<Workplace> workplacesFromDTO = workplaceService.findAllWorkplaces().stream()
                .filter(workplace1 -> Objects.equals(workplace1.getId(), developerDTO.getWorkplaceDTO().getId()))
                .collect(Collectors.toList());
        Developer developer = Developer.builder()
                .dob(developerDTO.getDob())
                .name(developerDTO.getName())
                .seniority(developerDTO.getSeniority())
                .workplaces(workplacesFromDTO)
                .build();
        developerRepository.save(developer);
        return developer;
    }
    public List<Developer> deleteDeveloper(Long developerID){
        developerRepository.deleteById(developerID);
        return developerRepository.findAll();
    }
}
