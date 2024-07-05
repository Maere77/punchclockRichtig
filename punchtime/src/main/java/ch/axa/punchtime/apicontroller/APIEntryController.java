package ch.axa.punchtime.apicontroller;

import ch.axa.punchtime.domain.Entry;
import ch.axa.punchtime.repositories.EntryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entries")
public class APIEntryController {


    @Autowired
    private EntryRepository entryRepos;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entry create(@RequestBody @Valid Entry entry) {
        return entryRepos.save(entry);
    }

    @GetMapping
    public Iterable<Entry> index() {
        return entryRepos.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entry> read(@PathVariable String id) {
        return ResponseEntity.of(entryRepos.findById(id));
    }

    @PutMapping("/{id}")
    public Entry update(@PathVariable String id, @RequestBody @Valid Entry entry) {
        entry.setId(id);
        return entryRepos.save(entry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Entry> delete(@PathVariable String id) {
        var person = entryRepos.findById(id);
        if (person.isPresent()) {
            entryRepos.delete(person.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}