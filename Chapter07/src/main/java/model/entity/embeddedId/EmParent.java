package model.entity.embeddedId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class EmParent {
    //
    @Id
    @Column(name = "PARENT_ID")
    private String id;
    private String name;
}
