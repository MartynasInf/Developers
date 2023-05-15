package developer.api.kosmos.service;

import developer.api.kosmos.dto.TrainDto;
import developer.api.kosmos.model.Train;
import developer.api.kosmos.repository.TrainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TrainService {

    private final TrainRepository trainRepository;

    /**
     * Finds all trains in DB which are manufactured after year 2000
     * @return list of trains newer than year 2000
     */

    public List<Train> findAllNewTrains(){
        return trainRepository.findAll().stream()
                .filter(train -> train.getYearCreated() >= 2000)
                .collect(Collectors.toList());
    }

    public List<Train> findAll(){
        return trainRepository.findAll();
    }
    public void saveTrain(TrainDto trainDto){
        Train train = new Train();
        if (trainDto.getId() == null) {
            train.setName(trainDto.getName());
            train.setCapacity(trainDto.getCapacity());
            train.setYearCreated(trainDto.getYearCreated());
        } else {
            train.setId(trainDto.getId());
            train.setName(trainDto.getName());
            train.setCapacity(trainDto.getCapacity());
            train.setYearCreated(trainDto.getYearCreated());
        }
        trainRepository.save(train);
    }

    public void delete(Long trainID){
        trainRepository.deleteById(trainID);
    }

}
