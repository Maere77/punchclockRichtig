package ch.axa.punchtime.apicontroller;

import ch.axa.punchtime.domain.Category;
import ch.axa.punchtime.repositories.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class APICategoryController {

    @Autowired
    private CategoryRepository categoryRepos;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@RequestBody @Valid Category category) {
        return categoryRepos.save(category);
    }

    @GetMapping
    public Iterable<Category> index() {
        return categoryRepos.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> read(@PathVariable String id) {
        return ResponseEntity.of(categoryRepos.findById(id));
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable String id, @RequestBody @Valid Category category) {
        category.setId(id);
        return categoryRepos.save(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable String id) {
        var person = categoryRepos.findById(id);
        if (person.isPresent()) {
            categoryRepos.delete(person.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
