package dev.vittorioexp.dgs;

import dev.vittorioexp.dgs.model.Agency;
import dev.vittorioexp.dgs.model.Agent;
import dev.vittorioexp.dgs.model.Property;
import dev.vittorioexp.dgs.model.PropertyType;
import dev.vittorioexp.dgs.repository.AgencyRepository;
import dev.vittorioexp.dgs.repository.AgentRepository;
import dev.vittorioexp.dgs.repository.PropertyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DgsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DgsApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            AgencyRepository agencyRepository,
            AgentRepository agentRepository,
            PropertyRepository propertyRepository
    ) {
        return args -> {

            agencyRepository.saveAll(List.of(
                    Agency
                            .builder()
                            .name("Dream Estates")
                            .taxCode("3LURH283R7F3F8IFUHJ394")
                            .build(),
                    Agency
                            .builder()
                            .name("Private properties DALLAS")
                            .taxCode("LKFHWIEURH8347R3R")
                            .build()
            ));


            agentRepository.saveAll(List.of(
                    Agent
                            .builder()
                            .fullName("Ada Smith")
                            .agency(agencyRepository.findById(1).orElse(null))
                            .build(),
                    Agent
                            .builder()
                            .fullName("Bob Muller")
                            .agency(agencyRepository.findById(1).orElse(null))
                            .build(),
                    Agent
                            .builder()
                            .fullName("Adam James")
                            .agency(agencyRepository.findById(1).orElse(null))
                            .build(),
                    Agent
                            .builder()
                            .fullName("William james")
                            .agency(agencyRepository.findById(1).orElse(null))
                            .build(),
                    Agent
                            .builder()
                            .fullName("Gregorio Roberts")
                            .agency(agencyRepository.findById(2).orElse(null))
                            .build()

            ));

            propertyRepository.saveAll(List.of(
                    Property
                            .builder()
                            .name("A32001")
                            .type(PropertyType.AGRICULTURAL_LAND)
                            .agency(agencyRepository.findById(1).orElse(null))
                            .build(),
                    Property
                            .builder()
                            .name("A32002")
                            .type(PropertyType.AGRICULTURAL_LAND)
                            .agency(agencyRepository.findById(1).orElse(null))
                            .build(),
                    Property
                            .builder()
                            .name("A32003")
                            .type(PropertyType.AGRICULTURAL_LAND)
                            .agency(agencyRepository.findById(1).orElse(null))
                            .build(),
                    Property
                            .builder()
                            .name("A32004")
                            .type(PropertyType.AGRICULTURAL_LAND)
                            .agency(agencyRepository.findById(1).orElse(null))
                            .build(),
                    Property
                            .builder()
                            .name("B5001")
                            .type(PropertyType.BUILDING_LAND)
                            .agency(agencyRepository.findById(1).orElse(null))
                            .build(),
                    Property
                            .builder()
                            .name("B5002")
                            .type(PropertyType.BUILDING_LAND)
                            .agency(agencyRepository.findById(1).orElse(null))
                            .build(),
                    Property
                            .builder()
                            .name("W001")
                            .type(PropertyType.WOODED_LAND)
                            .agency(agencyRepository.findById(1).orElse(null))
                            .build(),
                    Property
                            .builder()
                            .name("W002")
                            .type(PropertyType.WOODED_LAND)
                            .agency(agencyRepository.findById(1).orElse(null))
                            .build(),
                    Property
                            .builder()
                            .name("Agric-01")
                            .type(PropertyType.AGRICULTURAL_LAND)
                            .agency(agencyRepository.findById(2).orElse(null))
                            .build(),
                    Property
                            .builder()
                            .name("Agric-02")
                            .type(PropertyType.AGRICULTURAL_LAND)
                            .agency(agencyRepository.findById(2).orElse(null))
                            .build()

            ));
        };
    }
}
