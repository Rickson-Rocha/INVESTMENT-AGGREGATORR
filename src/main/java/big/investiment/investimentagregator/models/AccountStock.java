package big.investiment.investimentagregator.models;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_account_stock")
public class AccountStock {

    @EmbeddedId
    private AccountStockId id;

    @ManyToOne
    @MapsId("accountId")
    @JoinColumn(name = "account_id")
    private Account account;


    @ManyToOne
    @MapsId("stockId")
    @JoinColumn(name = "stock_id")
    private Stock stock;

    private Integer quantity;

}
