package bg.softuni.productshop.model.dto.exports.category;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "categories")
public class CategoryRootSummaryDto {

    @XmlElement(name = "category")
    private List<CategorySummaryDto> categories;

    public List<CategorySummaryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategorySummaryDto> categories) {
        this.categories = categories;
    }
}
