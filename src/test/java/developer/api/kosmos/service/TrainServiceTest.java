package developer.api.kosmos.service;

import developer.api.kosmos.model.Train;
import developer.api.kosmos.repository.TrainRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TrainServiceTest {

    @InjectMocks
    private TrainService trainService;

    @Mock
    private TrainRepository trainRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllNewTrains() {

        Train train1 = new Train(1L, "Train1", 10, 2001);
        Train train2 = new Train(2L, "Train2", 10, 1999);
        Train train3 = new Train(3L, "Train3", 10, 2010);
        List<Train> trains = new ArrayList<>();
        trains.add(train1);
        trains.add(train2);
        trains.add(train3);
        when(trainRepository.findAll()).thenReturn(trains);

        List<Train> resultList = trainService.findAllNewTrains();

        assertEquals(2, resultList.size());


    }
}