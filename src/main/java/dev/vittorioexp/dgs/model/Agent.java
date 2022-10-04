package dev.vittorioexp.dgs.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "agent")
public class Agent {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Column(nullable = false)
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Agent agent = (Agent) o;
        return id != null && Objects.equals(id, agent.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
