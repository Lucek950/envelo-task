package michal.ulik.recruitmenttask.controllers;

import lombok.RequiredArgsConstructor;
import michal.ulik.recruitmenttask.model.dtos.ResultDto;
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
public class ResultController {
    private final ResultService resultService;

    @GetMapping("/{codeFrom}/to/{codeTo}/{amount}")
    public ResultDto getConvertCurrency(@PathVariable("codeFrom") String codeFrom
            ,@PathVariable("codeTo") String codeTo
            ,@PathVariable("amount") BigDecimal amount){
        return resultService.convertCurrency(codeFrom, codeTo, amount);
    }

    @GetMapping("/{codeFrom}/to-all")
    public List<ResultDto> getConvertCurrencies(@PathVariable("codeFrom") String codeFrom){
        return resultService.convertCurrencies(codeFrom);
    }
}
