package michal.ulik.recruitmenttask.model.dtos.nbpRate;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ValueNbpRateDto {
    private BigDecimal mid;
}
