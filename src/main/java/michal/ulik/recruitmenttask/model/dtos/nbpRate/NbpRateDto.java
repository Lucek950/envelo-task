package michal.ulik.recruitmenttask.model.dtos.nbpRate;

import lombok.*;
import lombok.experimental.SuperBuilder;
import michal.ulik.recruitmenttask.model.dtos.CurrencyDto;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class NbpRateDto extends CurrencyDto {
    private List<ValueNbpRateDto> rates;
}
