package ch.axa.punchtime.service;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EntryServiceTest {

    /*
    @Inject
    private EntryRepo entryService;

    @Test
    public void testIfEntryCanBeSaved() {
        Entry entry = new Entry();
        entry.setDescription("Awesome");
        entry.setCheckIn(LocalDateTime.now());
        entry.setCheckOut(LocalDateTime.now().plusHours(2));

        entryService.save(entry);


        Optional<Entry> entryDB = EntryRepo.findById(entry.getId());
        assertEquals(entry.getDescription(), entryDB.get().getDescription());

    */
}