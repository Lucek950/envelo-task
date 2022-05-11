package michal.ulik.recruitmenttask.controllers;

import lombok.RequiredArgsConstructor;
import michal.ulik.recruitmenttask.model.dtos.RateDto;
import michal.ulik.recruitmenttask.services.LogService;
import michal.ulik.recruitmenttask.services.RateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/currency")
public class RateController {
    private final LogService logService;
    private final RateService rateService;

    @GetMapping
    public List<RateDto> getAllRates(){
        logService.setLog("getAllRates()");
        return rateService.getAllRates();
    }
}
