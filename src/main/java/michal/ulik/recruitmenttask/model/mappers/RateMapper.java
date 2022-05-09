package michal.ulik.recruitmenttask.model.mappers;

import michal.ulik.recruitmenttask.model.dtos.RateDto;
import michal.ulik.recruitmenttask.model.enities.Rate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RateMapper {
    RateDto rateToRateDto(Rate rate);
    Rate rateDtoToRate(RateDto rateDto);
    List<RateDto> ratesToRatesDto(List<Rate> rates);
}
