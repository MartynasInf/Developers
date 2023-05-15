package developer.api.kosmos.controller;

import developer.api.kosmos.dto.DestinationDto;
import developer.api.kosmos.model.Destination;
import developer.api.kosmos.service.DestinationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destination")
@AllArgsConstructor
public class DestinationController {

    private final DestinationService destinationService;

    @CrossOrigin
    @PostMapping("/")
    public List<Destination>  save(@RequestBody DestinationDto destinationDto){
        destinationService.save(destinationDto);
        System.out.println(destinationDto);
        return destinationService.findAll();
    }

    @CrossOrigin
    @DeleteMapping("/{destinationId}")
    public void delete (@PathVariable Long destinationId){
        System.out.println(destinationId);
        destinationService.delete(destinationId);
    }
}
