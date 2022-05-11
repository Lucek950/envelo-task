package michal.ulik.recruitmenttask.model.dtos;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class CurrencyDto {
    private String currency;
    private String code;
}
