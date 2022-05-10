package michal.ulik.recruitmenttask.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import michal.ulik.recruitmenttask.exceptions.RateNotFoundException;
import michal.ulik.recruitmenttask.model.dtos.RateDto;
import michal.ulik.recruitmenttask.model.dtos.ResultDto;
import michal.ulik.recruitmenttask.model.enities.Rate;
import michal.ulik.recruitmenttask.model.mappers.RateMapper;
import michal.ulik.recruitmenttask.model.repositories.RateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class RateService {
    private final RateRepository rateRepository;
    private final RateMapper rateMapper;

    public List<RateDto> getAllRates(){
        List<Rate> rates = rateRepository.findAll();
        return rateMapper.ratesToRatesDto(rates);
    }

    public RateDto getRate(Long id){
        Rate rate = rateRepository.findById(id).orElseThrow(() -> {
            String message = "Rate not found " + id;
            log.error(message);
            return new RateNotFoundException(message);
        });
        return rateMapper.rateToRateDto(rate);
    }

}
