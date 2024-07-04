package ch.axa.punchtime.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "entry")
@Data
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private LocalDateTime check_in;

    @Column(nullable = false)
    private LocalDateTime check_out;

    private String description;


}
