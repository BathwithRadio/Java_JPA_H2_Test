package model.entity.joinTable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Parent {
    //
    @Id
    @GeneratedValue
    @Column(name = "PARENT_ID")
    private long id;
    private String name;

    @OneToMany(mappedBy = "parent")
    private List<Child> children = new ArrayList<>();
}
