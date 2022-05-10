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

    @GetMapping("/{idFrom}/to/{idTo}/{amount}")
    public ResultDto getConvertCurrency(@PathVariable("idFrom") long idFrom
            ,@PathVariable("idTo") long idTo
            ,@PathVariable("amount") BigDecimal amount){
        return resultService.convertCurrency(idFrom, idTo, amount);
    }

    @GetMapping("/{idFrom}/to-all")
    public List<ResultDto> getConvertCurrencies(@PathVariable("idFrom") long idFrom){
        return resultService.convertCurrencies(idFrom);
    }
}
