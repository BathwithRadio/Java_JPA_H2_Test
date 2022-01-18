package model.entity.cascade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Parent {
    //
    public Parent(String  id){
        this.id = id;
    }

    @Id
    private String  id;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Child> children  = new ArrayList<>();
}
