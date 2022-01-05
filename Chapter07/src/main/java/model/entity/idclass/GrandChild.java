package model.entity.idclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@EqualsAndHashCode
public class GrandChild {
    //
    @Id
    @ManyToOne
    @JoinColumns ({
            @JoinColumn (name = "PARENT_ID"),
            @JoinColumn (name = "CHILD_ID")
    })
    private Child child;

    @Id
    @Column(name = "GRANDCHILD_ID")
    private String id;

    private String name;
}
