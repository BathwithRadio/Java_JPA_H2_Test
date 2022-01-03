package model.entity.embeddedId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class EmParent {
    //
    @EmbeddedId
    private EmParentId id;
    private String name;
}
