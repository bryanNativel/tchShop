package com.example.springTdBeuh.controller;
import com.example.springTdBeuh.model.Variety;
import com.example.springTdBeuh.repo.VarietyRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class VarietyController {

    private final VarietyRepository repository;

    public VarietyController(VarietyRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/variety")
    List<Variety> all() {
        return repository.findAll();
    }

    // end::get-aggregate-root[]
    @PostMapping("/variety")
    Variety newVariety(@RequestBody Variety newVariety) {
        return repository.save(newVariety);
    }

    // Single item
    @GetMapping("/variety/{id}")
    Optional<Variety> one(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/variety/{id}")
    Variety replaceVariety(@RequestBody Variety newVariety, @PathVariable Long id) {

        return repository.findById(id)
                .map(variety -> {
                    variety.setName(newVariety.getName());
                    variety.setTHCRate(newVariety.getTHCRate());
                    return repository.save(variety);
                })
                .orElseGet(() -> {
                    newVariety.setId(id);
                    return repository.save(newVariety);
                });
    }

    @DeleteMapping("/variety/{id}")
    void deleteVariety(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
