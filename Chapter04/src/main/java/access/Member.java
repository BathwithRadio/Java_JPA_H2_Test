package access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import start.RoleType;

import javax.persistence.*;
import java.util.Date;


@Entity
@NoArgsConstructor
@Table(name="MEMBER")
public class Member {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Transient
    private String firstName;

    @Transient
    private String lastName;


    @Access(AccessType.PROPERTY)
    public String getFullName(){
        //
        return firstName + lastName;
    }

    public void setFullName(String fullName) {
        //

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
