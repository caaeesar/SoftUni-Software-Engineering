package bg.softuni.cardealer.model.dto.exports;

import bg.softuni.cardealer.model.dto.exports.SupplierNotImporterDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "suppliers")
public class SupplierRootNotImporterDto {

    @XmlElement(name = "supplier")
    private List<SupplierNotImporterDto> suppliers;

    public List<SupplierNotImporterDto> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierNotImporterDto> suppliers) {
        this.suppliers = suppliers;
    }
}
