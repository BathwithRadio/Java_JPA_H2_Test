package embbeded.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
    //
    public Address(String city) {
        this.city = city;
    }

    @Column(name = "city")
    private String city;
    private String street;
    private String zipcode;
}
