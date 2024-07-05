package ch.axa.punchtime.repositories;

import ch.axa.punchtime.domain.Entry;
import org.springframework.data.repository.CrudRepository;

public interface EntryRepo extends CrudRepository<Entry, String> {

}