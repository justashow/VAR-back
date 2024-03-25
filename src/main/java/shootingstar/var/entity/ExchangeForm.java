package shootingstar.var.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExchangeForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exchangeId;

    private String exchangeUUID;

    @ManyToOne
    @JoinColumn(name = "userId")
    @NotNull
    private User user;

    private Long exchangePoint;

    private String exchangeAccount;

    private String exchangeBank;

    private String exchangeAccountHolder;

    private ExchangeStatus exchangeStatus;

    @Builder
    public ExchangeForm(User user, Long exchangePoint, String exchangeAccount, String exchangeBank, String exchangeAccountHolder) {
        this.exchangeUUID = UUID.randomUUID().toString();
        this.user = user;
        this.exchangePoint = exchangePoint;
        this.exchangeAccount = exchangeAccount;
        this.exchangeBank = exchangeBank;
        this.exchangeAccountHolder = exchangeAccountHolder;
        this.exchangeStatus = ExchangeStatus.STANDBY;
    }
}