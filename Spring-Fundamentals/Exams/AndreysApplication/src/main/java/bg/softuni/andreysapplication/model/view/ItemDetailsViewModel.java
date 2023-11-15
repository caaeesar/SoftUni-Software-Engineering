package bg.softuni.andreysapplication.model.view;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemDetailsViewModel {

    private String id;

    private String name;

    private BigDecimal price;

    private String imageUrl;

    private String description;
}
