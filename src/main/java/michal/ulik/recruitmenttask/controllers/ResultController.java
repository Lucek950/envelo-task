package michal.ulik.recruitmenttask.controllers;

import lombok.RequiredArgsConstructor;
import michal.ulik.recruitmenttask.model.dtos.ResultDto;
import michal.ulik.recruitmenttask.services.LogService;
import michal.ulik.recruitmenttask.services.ResultService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/convert")
public class ResultController{
    private final LogService logService;
    private final ResultService resultService;

    @GetMapping("/{fromCode}/to/{codeTo}/{amount}")
    public ResultDto getConvertCurrency(@PathVariable("fromCode") String fromCode
            , @PathVariable("codeTo") String toCode
            , @PathVariable("amount") BigDecimal amount){
        logService.setLog("getConvertCurrency(String formCode, String toCode, BigDecimal amount)",
                fromCode, toCode, amount);
        return resultService.convertCurrency(fromCode, toCode, amount);
    }

    @GetMapping("/{fromCode}/to-all")
    public List<ResultDto> getConvertCurrencies(@PathVariable("fromCode") String fromCode){
        logService.setLog("getConvertCurrencies(String formCode)", fromCode);
        return resultService.convertCurrencies(fromCode);
    }
}
