package michal.ulik.recruitmenttask.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import michal.ulik.recruitmenttask.model.dtos.RateDto;
import michal.ulik.recruitmenttask.model.dtos.ResultDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ResultService {
    private final RateService rateService;

    public ResultDto convertCurrency(long fromRateId, long toRateId, BigDecimal amount){
        RateDto from = rateService.getRate(fromRateId);
        RateDto to = rateService.getRate(toRateId);

        BigDecimal valueTo = to.getMid();
        BigDecimal valueFrom = from.getMid();
        BigDecimal result = valueFrom.divide(valueTo, RoundingMode.FLOOR).multiply(amount);

        return ResultDto.builder()
                .from(from.getCurrency())
                .to(to.getCurrency())
                .value(result)
                .build();
    }

    public List<ResultDto> convertCurrencies(long fromRateId){
        List<RateDto> allRates = rateService.getAllRates();
        return allRates.stream().map(rate -> convertCurrency(fromRateId, rate.getId(), BigDecimal.ONE)).toList();
    }
}
