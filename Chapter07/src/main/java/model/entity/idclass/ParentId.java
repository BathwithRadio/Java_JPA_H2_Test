package model.entity.idclass;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

public class ParentId implements Serializable {
    //
    private String id1;
    private String id2;

    public ParentId() {
        //
        System.out.println("ParentId NoArg 생성자 동작 확인");
    }

    public ParentId(String id1, String id2) {
        //
        System.out.println("ParentId AllArg 생성자 동작 확인");
        this.id1 = id1;
        this.id2 = id2;
    }
}
