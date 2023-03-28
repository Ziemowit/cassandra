package pl.ziemowit.cassandra.web;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.ziemowit.cassandra.repo.PersonCreateDTO;
import pl.ziemowit.cassandra.repo.PersonResponseDTO;
import pl.ziemowit.cassandra.service.PersonService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {

  private final PersonService personService;

  @PostMapping
  public Mono<PersonResponseDTO> create(@RequestBody @Valid PersonCreateDTO request) {
    log.info("[PersonController][create]: request={}", request);
    return personService.create(request);
  }

  @GetMapping("/by-city")
  public Flux<PersonResponseDTO> findByCity(@RequestParam("city") @NotBlank String city) {
    log.info("[PersonController][findByCity]: city={}", city);
    return personService.findByCity(city)
                        .map(PersonResponseDTO::from);
  }

  @GetMapping("/by-birth-date")
  public Flux<PersonResponseDTO> findByBirthDate(@RequestParam("birthDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @NotNull LocalDate birthDate) {
    log.info("[PersonController][findByBirthDate]: birthDate={}", birthDate);
    return personService.findByBirthDate(birthDate)
                        .map(PersonResponseDTO::from);
  }

}
