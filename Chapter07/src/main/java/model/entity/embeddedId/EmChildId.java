package model.entity.embeddedId;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class EmChildId implements Serializable {
    //
    private String parentId; //@MapsId("parentID")로 매핑

    @Column(name = "CHILD_ID")
    private String id;

}
