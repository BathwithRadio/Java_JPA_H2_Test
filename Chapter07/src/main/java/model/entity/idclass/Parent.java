package model.entity.idclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Parent {
    //
    @Id
    @Column(name = "PARENT_ID")
    private String id1; //ParentId.id1과 연결
    private String name;
}
