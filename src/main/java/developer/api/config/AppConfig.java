package developer.api.config;

import developer.api.model.Developer;
import developer.api.model.Workplace;
import developer.api.repository.DeveloperRepository;
import developer.api.repository.WorkplaceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    CommandLineRunner commandLineRunner(DeveloperRepository developerRepository, WorkplaceRepository workplaceRepository) {
        return args -> {

            Workplace nortal = Workplace.builder()
                    .name("Nortal")
                    .address("Rinktines g. 5, Vilnius")
                    .build();
            nortal = workplaceRepository.save(nortal);
            List<Workplace> workplaces = new ArrayList<>();
            workplaces.add(nortal);
            Developer linas = Developer.builder()
                    .seniority("Senior")
                    .name("Linas")
                    .dob(LocalDate.of(1991, 6, 15))
                    .workplaces(workplaces)
                    .build();
            nortal.setDevelopers(Arrays.asList(linas));

            //developerRepository.save(linas);
            developerRepository.save(linas);
            workplaceRepository.saveAll(workplaces);

        };
    }
}
