package michal.ulik.recruitmenttask.services;

import lombok.RequiredArgsConstructor;
import michal.ulik.recruitmenttask.model.dtos.RateDto;
import michal.ulik.recruitmenttask.model.enities.Rate;
import michal.ulik.recruitmenttask.model.mappers.RateMapper;
import michal.ulik.recruitmenttask.model.repositories.RateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RateService {
    private final RateRepository rateRepository;
    private final RateMapper rateMapper;

    public List<RateDto> getAllRates(){
        List<Rate> rates = rateRepository.findAll();
        return rateMapper.ratesToRatesDto(rates);
    }
}
