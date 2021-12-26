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
    @Column(name = "MEMBER_ID")
    private String id;

    private String username;

    //연관관계 매핑
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    //생성자 추가
    public Member (String id, String username) {
        //
        this.id = id;
        this.username = username;
    }

    //setter수정
    public void setTeam(Team team) {
        //
        this.team = team;
        team.getMembers().add(this);
    }
}
