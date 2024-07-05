package ch.axa.punchtime.repositories;

import ch.axa.punchtime.domain.Entry;
import org.springframework.data.repository.CrudRepository;

public interface EntryRepository extends CrudRepository<Entry, String> {

}