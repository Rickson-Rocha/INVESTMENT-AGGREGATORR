package big.investiment.investimentagregator.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_account")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "account_id")
    private UUID accountId;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "account")
    private List<AccountStock> stocks;

    @OneToOne(mappedBy = "account")
    @PrimaryKeyJoinColumn
    private BillingAddress billingAddress;


}
