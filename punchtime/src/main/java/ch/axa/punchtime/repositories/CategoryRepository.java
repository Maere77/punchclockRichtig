package ch.axa.punchtime.repositories;

import ch.axa.punchtime.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, String> {
}
