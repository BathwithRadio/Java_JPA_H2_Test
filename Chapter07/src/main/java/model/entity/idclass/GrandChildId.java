package model.entity.idclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class GrandChildId implements Serializable {
    //
    private ChildId childId; // GrandChild.parent 매핑
    private String id;       // GrandChild.id 매핑
}
