package bg.softuni.cardealer.model.dto.exports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "sales")
public class SaleRootWithDiscountInfoDto {

    @XmlElement(name = "sale")
    private List<SaleWrapperDto> sales;

    public List<SaleWrapperDto> getSales() {
        return sales;
    }

    public void setSales(List<SaleWrapperDto> sales) {
        this.sales = sales;
    }
}
