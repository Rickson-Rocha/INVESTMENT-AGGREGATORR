package big.investiment.investimentagregator.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_stock")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Stock {

    @Id
    private String stockId;

    private String description;


}
