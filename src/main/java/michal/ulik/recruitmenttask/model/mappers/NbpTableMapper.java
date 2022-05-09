package michal.ulik.recruitmenttask.model.mappers;

import michal.ulik.recruitmenttask.model.dtos.NbpTableDto;
import michal.ulik.recruitmenttask.model.enities.NbpTable;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RateMapper.class})
public interface NbpTableMapper {

    @Mapping(source = "nameTable", target = "table")
    NbpTableDto nbpTableToNbpTableDto(NbpTable nbpTable);

    @Mapping(source = "table", target = "nameTable")
    NbpTable nbpTableDtoToNbpTable(NbpTableDto nbpTableDto);
}
