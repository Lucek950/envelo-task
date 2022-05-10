package michal.ulik.recruitmenttask.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import michal.ulik.recruitmenttask.model.dtos.RateDto;
import michal.ulik.recruitmenttask.model.dtos.nbpRate.NbpRateDto;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class RateService {
    private final NbpService nbpService;

    public List<RateDto> getAllRates(){
        return nbpService.getNbpTableDtoTemplate().getRates();
    }

    public RateDto getRate(String code){
        NbpRateDto nbpRateDto = nbpService.getRateDtoTemplate(code);
        return RateDto.builder()
                .currency(nbpRateDto.getCurrency())
                .code(nbpRateDto.getCode())
                .mid(nbpRateDto.getRates().get(0).getMid())
                .build();
    }

}
