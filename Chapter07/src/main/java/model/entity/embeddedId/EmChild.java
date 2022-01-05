package model.entity.embeddedId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class EmChild {
    //
    @EmbeddedId
    private EmChildId id;

    @MapsId("parentId") //ChildId.parentId 매핑
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    public EmParent parent;

    private String name;
}
