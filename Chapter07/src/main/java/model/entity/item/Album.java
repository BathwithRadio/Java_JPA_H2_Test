package model.entity.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@DiscriminatorValue("A")
@AllArgsConstructor
public class Album extends Item {
    //
    private String artist;
    private String etc;

    @Override
    public String toString() {
        return "Album{" +
                "artist='" + artist + '\'' +
                ", etc='" + etc + '\'' +
                '}';
    }
}
