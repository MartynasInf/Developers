package developer.api.kosmos.service;

import developer.api.kosmos.dto.DestinationDto;
import developer.api.kosmos.model.Destination;
import developer.api.kosmos.model.Train;
import developer.api.kosmos.repository.DestinationRepository;
import developer.api.kosmos.repository.TrainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DestinationService {

    private final DestinationRepository destinationRepository;
    private final TrainRepository trainRepository;

    public void save(DestinationDto destinationDto) {
        Destination destination = new Destination();
        Train train = trainRepository.findById(destinationDto.getTrainID()).get();
        destination.setTrain(train);
        destination.setName(destinationDto.getName());
        destination.setDistance(destinationDto.getDistance());
        destinationRepository.save(destination);
    }

    public List<Destination> findAll(){
        return destinationRepository.findAll();
    }
    public void delete(Long destinationId){
        destinationRepository.deleteById(destinationId);
    }
}
