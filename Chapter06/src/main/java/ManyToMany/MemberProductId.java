package ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
public class MemberProductId implements Serializable {
    //
    private String member; //MemberProduct.member 와 연결
    private String product; //MemberProduct.product 와 연결

}
