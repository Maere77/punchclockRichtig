package ch.axa.punchtime.repositories;

import ch.axa.punchtime.domain.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, String> {
}
