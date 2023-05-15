package developer.api.kosmos.controller;

import developer.api.kosmos.dto.TrainDto;
import developer.api.kosmos.model.Train;
import developer.api.kosmos.service.TrainService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trains")
@AllArgsConstructor

public class TrainController {

    private final TrainService trainService;

    @CrossOrigin
    @GetMapping("/")
    public List<Train> getTrains(){
        return trainService.findAllNewTrains();
    }

    @CrossOrigin
    @PostMapping("/")
    public List<Train> save(@RequestBody TrainDto trainDto){
        trainService.saveTrain(trainDto);
        return trainService.findAllNewTrains();
    }


    @CrossOrigin
    @GetMapping("/all")
    public List<Train> getAll(){
        return trainService.findAll();
    }

    @CrossOrigin
    @DeleteMapping("/{trainID}")
    public void delete (@PathVariable Long trainID){
        trainService.delete(trainID);
    }
}
