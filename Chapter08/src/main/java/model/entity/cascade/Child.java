package model.entity.cascade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Child {
    //
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Parent parent;
}
