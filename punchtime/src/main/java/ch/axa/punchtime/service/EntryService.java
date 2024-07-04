package ch.axa.punchtime.service;

import ch.axa.punchtime.domain.Entry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class EntryService {

    @PersistenceContext
    private EntityManager entityManager;

    public void createEntry(Entry entry) {
        entityManager.persist(entry);
    }

    public void update(Entry entry) {
        entityManager.merge(entry);
    }

    public void deleteEntry(Entry entry) {
        entityManager.remove(entry);
    }

    public Entry findById(String id) {
        return entityManager.find(Entry.class, id);
    }

    public Iterable<Entry> findAll() {
        return entityManager.createQuery("SELECT e FROM Entry e", Entry.class).getResultList();
    }
}
