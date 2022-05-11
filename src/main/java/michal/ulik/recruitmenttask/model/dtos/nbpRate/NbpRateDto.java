package michal.ulik.recruitmenttask.model.dtos.nbpRate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
