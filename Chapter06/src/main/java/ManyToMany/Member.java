package ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {
    //
    @Id
    @Column(name = "MEMBER_ID")
    private String id;
    private String userName;
    //역방향
    @OneToMany(mappedBy = "member")
    private List<Orders> orders;
}
