package michal.ulik.recruitmenttask.model.dtos;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RateDto {
    private Long id;
    private String currency;
    private String code;
    private BigDecimal mid;
}
