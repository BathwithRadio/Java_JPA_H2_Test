package model.entity.embeddedId;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class EmGrandChildId implements Serializable {
    //
    private EmChildId childId; //@MapsId("childId") 로 매핑

    @Column(name = "GRANDCHILD_ID")
    private String id;
}
