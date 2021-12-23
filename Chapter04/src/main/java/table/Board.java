package table;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@SequenceGenerator(
        name = "BOARD_SEQ_GENERATOR",
        sequenceName = "BOARD_SEQ", // 매핑할 DB 시퀀스 이름
        initialValue = 1, allocationSize = 2
)
public class Board {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "BOARD_SEQ_GENERATOR")
    private Long id;
    private String name;
}


