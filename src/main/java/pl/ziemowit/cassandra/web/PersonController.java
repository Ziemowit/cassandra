package pl.ziemowit.cassandra.web;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.ziemowit.cassandra.model.PersonByCity;
import pl.ziemowit.cassandra.model.PersonByCityKey;
import pl.ziemowit.cassandra.repo.PersonByCityRepo;
import pl.ziemowit.cassandra.repo.PersonCreateDTO;
import pl.ziemowit.cassandra.repo.PersonResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {

  private final PersonByCityRepo personByCityRepo;

  @PostMapping
  public Mono<PersonResponseDTO> create(@RequestBody @Valid PersonCreateDTO request) {
    log.info("[PersonController][create]: request={}", request);
    return personByCityRepo.save(new PersonByCity(new PersonByCityKey(request.city(),
                                                                      request.email()),
                                                  request.firstName(),
                                                  request.lastName(),
                                                  request.birthDate()))
                           .map(PersonResponseDTO::from);
  }

  @GetMapping("/by-city")
  public Flux<PersonResponseDTO> findByCity(@RequestParam("city") @NotBlank String city) {
    log.info("[PersonController][findByCity]: city={}", city);
    return personByCityRepo.findByKeyCity(city)
                           .map(PersonResponseDTO::from);
  }

}
