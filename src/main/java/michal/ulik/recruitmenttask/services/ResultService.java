package michal.ulik.recruitmenttask.services;

import lombok.RequiredArgsConstructor;
import michal.ulik.recruitmenttask.model.dtos.RateDto;
import michal.ulik.recruitmenttask.model.dtos.ResultDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ResultService {
    private final LogService logService;
    private final RateService rateService;

    public ResultDto convertCurrency(String fromCode, String toCode, BigDecimal amount){
        logService.setLog("convertCurrency(String fromCode, String toCode, BigDecimal amount)",
                        fromCode, toCode, amount);
        RateDto from = rateService.getRate(fromCode);
        RateDto to = rateService.getRate(toCode);

        BigDecimal valueFrom = from.getMid();
        BigDecimal valueTo = to.getMid();
        BigDecimal result = valueFrom.divide(valueTo, RoundingMode.FLOOR).multiply(amount);

        return ResultDto.builder()
                .from(from.getCurrency())
                .to(to.getCurrency())
                .amount(amount)
                .value(result.setScale(2, RoundingMode.CEILING))
                .build();
    }

    public List<ResultDto> convertCurrencies(String fromCode){
        logService.setLog("convertCurrencies(String fromCode)", fromCode);
        List<RateDto> allRates = rateService.getAllRates();
        return allRates.stream().map(rate -> convertCurrency(fromCode, rate.getCode(), BigDecimal.ONE)).toList();
    }
}
