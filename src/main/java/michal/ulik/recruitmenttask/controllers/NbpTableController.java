package michal.ulik.recruitmenttask.controllers;

import lombok.RequiredArgsConstructor;
import michal.ulik.recruitmenttask.model.dtos.NbpTableDto;
import michal.ulik.recruitmenttask.services.NbpTableService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/nbp-table")
public class NbpTableController {
    private final NbpTableService nbpTableService;

    @GetMapping
    public NbpTableDto createNbpTable(){
        return nbpTableService.getNbpTableDtoTemplate();
    }
}
