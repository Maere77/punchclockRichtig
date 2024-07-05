package ch.axa.punchtime.service;

import ch.axa.punchtime.domain.Entry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EntryService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void create(Entry entry) {
        this.entityManager.persist(entry);
    }

    @Transactional
    public Entry findById(String id) {
        return this.entityManager.find(Entry.class, id);
    }

    @Transactional
    public void update(Entry entry) {
        this.entityManager.merge(entry);
    }

    @Transactional
    public Iterable<Entry> findAll() {
        return this.entityManager.createQuery("SELECT e FROM Entry e", Entry.class).getResultList();
    }

    @Transactional
    public void deleteEntry(Entry entry) {
        this.entityManager.remove(entry);
    }
}