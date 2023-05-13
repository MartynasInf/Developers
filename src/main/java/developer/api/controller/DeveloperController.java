package developer.api.controller;

import developer.api.model.Developer;
import developer.api.model.DeveloperDTO;
import developer.api.model.Workplace;
import developer.api.model.WorkplaceDTO;
import developer.api.service.DeveloperService;
import developer.api.service.WorkplaceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/developer")
public class DeveloperController {

    private final DeveloperService developerService;
    private final WorkplaceService workplaceService;

    //@Value("${developer.app.name}")
    @Value("${developer.app.name}")
    private String  applicationName;
    public DeveloperController(DeveloperService developerService, WorkplaceService workplaceService) {
        this.developerService = developerService;
        this.workplaceService = workplaceService;
    }
    @GetMapping("/name")
    public String getAppName(){
        return applicationName;
    }
    @GetMapping("/")
    @CrossOrigin
    public List<Developer> getDeveloper(){
        return developerService.findAllDevelopers();
    }

    @PostMapping("/")
    @CrossOrigin
    public Developer saveDeveloper(@RequestBody DeveloperDTO developerDTO){
        developerService.saveDeveloper(developerDTO);
        return new Developer();
    }
    @DeleteMapping("/{developerID}")
    @CrossOrigin
    public List<Developer> deleteDeveloper(@PathVariable Long developerID){
        System.out.println("Deleting api was hit");
        return developerService.deleteDeveloper(developerID);
    }
}
