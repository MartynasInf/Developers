package developer.api.controller;

import developer.api.model.Workplace;
import developer.api.model.WorkplaceDTO;
import developer.api.service.WorkplaceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workplace")
@AllArgsConstructor
public class WorkplaceController {

    private final WorkplaceService workplaceService;


    @GetMapping("/")
    @CrossOrigin
    public List<Workplace> findAllWorkplaces(){
        return workplaceService.findAllWorkplaces();
    }

    @PostMapping("/")
    @CrossOrigin
    public List<Workplace> addNewWorkplace(@RequestBody WorkplaceDTO workplaceDTO){
        return workplaceService.addNewWorkplace(workplaceDTO);
    }

}
