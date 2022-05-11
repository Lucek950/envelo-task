package michal.ulik.recruitmenttask.model.dtos;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class RateDto extends CurrencyDto{
    private BigDecimal mid;
}
