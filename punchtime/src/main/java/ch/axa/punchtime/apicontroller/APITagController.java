package ch.axa.punchtime.apicontroller;


import ch.axa.punchtime.domain.Tag;
import ch.axa.punchtime.repositories.TagRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tags")
public class APITagController {

    @Autowired
    private TagRepository tagRepos;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tag create(@RequestBody @Valid Tag tag) {
        return tagRepos.save(tag);
    }

    @GetMapping
    public Iterable<Tag> index() {
        return tagRepos.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> read(@PathVariable String id) {
        return ResponseEntity.of(tagRepos.findById(id));
    }

    @PutMapping("/{id}")
    public Tag update(@PathVariable String id, @RequestBody @Valid Tag tag) {
        tag.setId(id);
        return tagRepos.save(tag);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tag> delete(@PathVariable String id) {
        var person = tagRepos.findById(id);
        if (person.isPresent()) {
            tagRepos.delete(person.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
