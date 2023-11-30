package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "magic_wands")
@Setter
@Getter
public class MagicWand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "magic_wand_creator", length = 100)
    private String creator;
    @Column(name = "magic_wand_size")
    private int size;
}
