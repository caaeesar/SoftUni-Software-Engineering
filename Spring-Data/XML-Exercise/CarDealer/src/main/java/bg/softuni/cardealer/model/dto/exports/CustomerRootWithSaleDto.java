package bg.softuni.cardealer.model.dto.exports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customers")
public class CustomerRootWithSaleDto {

    @XmlElement(name = "customer")
    private List<CustomerWithSaleDto> customers;

    public List<CustomerWithSaleDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerWithSaleDto> customers) {
        this.customers = customers;
    }
}
