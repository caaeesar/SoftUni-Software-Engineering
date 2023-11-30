package bg.softuni.cardealer.model.dto.imports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customers")
public class CustomerRootSeedDto {

    @XmlElement(name = "customer")
    private List<CustomerSeedDto> customers;

    public List<CustomerSeedDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerSeedDto> customers) {
        this.customers = customers;
    }
}
