package model.entity.proxy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    //
    @Id
    private String id;
    private String username;
    private Integer age;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Team team;
//
//    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
//    private List<Order> orders;
}
