package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class BankAccount extends BillingDetail {

    @Column(name = "bank_name")
    private String bankName;
    @Column(name = "SWIFT_code", unique = true)
    private String swiftCode;

}
