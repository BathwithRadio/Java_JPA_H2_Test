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

    //연관관계 매핑
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    //setter수정
    public void setTeam(Team team) {
        //
        this.team = team;

        //무한루프 방지
        if (!team.getMembers().contains(this)) {
            team.getMembers().add(this);
        }
    }
}
