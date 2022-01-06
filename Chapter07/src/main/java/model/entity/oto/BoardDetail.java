package model.entity.oto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
public class BoardDetail {
    //
    @Id
    private Long boardId;

    @MapsId // BoardDetail.boardId매핑
    @OneToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    private String content;
}
