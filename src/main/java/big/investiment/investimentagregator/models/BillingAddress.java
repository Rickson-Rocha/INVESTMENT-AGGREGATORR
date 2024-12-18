package big.investiment.investimentagregator.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "tb_billing_address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingAddress {

    @Id
    @Column(name= "account_id")
    private UUID id;


    private String street;


    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    private Account account;


    private Integer number;





}
