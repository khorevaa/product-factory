package ru.pf.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * CR - Configuration Repository
 * @author a.kakushin
 */
@Entity
@Table(name = "CR")
@Data
public class Cr implements PfEntity<Cr, Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;
    String comment;

    String tcp;
    String http;

    public Cr() {}

    @Override
    public Long getId() {
        return this.id;
    }
}
