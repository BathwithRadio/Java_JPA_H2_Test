package member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {
    //
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private long id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID", insertable = false,
            updatable = false)
    private Team team;

    public Member(String username) {
        //
        this.username = username;
    }
}
