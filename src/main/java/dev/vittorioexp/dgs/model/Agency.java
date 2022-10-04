package dev.vittorioexp.dgs.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "agency")
public class Agency {
    @Id
    @SequenceGenerator(
            name = "agency_sequence",
            sequenceName = "agency_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "agency_sequence"
    )
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String taxCode;

    @OneToMany(
            mappedBy = "agency",
            cascade = CascadeType.ALL
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Agent> agents;

    @OneToMany(
            mappedBy = "agency",
            cascade = CascadeType.ALL
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Property> properties;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Agency agency = (Agency) o;
        return id != null && Objects.equals(id, agency.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
