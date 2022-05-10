package michal.ulik.recruitmenttask.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import michal.ulik.recruitmenttask.model.dtos.NbpTableDto;
import michal.ulik.recruitmenttask.model.enities.NbpTable;
import michal.ulik.recruitmenttask.model.mappers.NbpTableMapper;
import michal.ulik.recruitmenttask.model.repositories.NbpTableRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
@Slf4j
public class NbpTableService {
    private final NbpTableRepository nbpTableRepository;
    private final NbpTableMapper nbpTableMapper;

    public NbpTableDto getNbpTableDtoTemplate(){
        String url = "http://api.nbp.pl/api/exchangerates/tables/A/";
        NbpTable[] nbpTable = new RestTemplate().getForObject(url, NbpTable[].class);
        assert nbpTable != null;
        return nbpTableMapper.nbpTableToNbpTableDto(nbpTable[0]);
    }

    public NbpTableDto createNbpTable(){
        NbpTableDto nbpTableDto = getNbpTableDtoTemplate();
        NbpTable nbpTable = nbpTableMapper.nbpTableDtoToNbpTable(nbpTableDto);
        NbpTable savedNbpTable = nbpTableRepository.save(nbpTable);
        return nbpTableMapper.nbpTableToNbpTableDto(savedNbpTable);
    }
}
