package batch.mapper;

import batch.dto.ScpiDtoOut;
import batch.dto.StatYearDtoOut;
import batch.entity.Scpi;
import batch.entity.StatYear;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ScpiMapper {

    @Mapping(target = "statYear", source = "statYears", qualifiedByName = "firstStatYear")
    @Mapping(target = "location", source = "locations", qualifiedByName = "highestPercentageLocation")
    @Mapping(target = "sector", source = "sectors", qualifiedByName = "highestPercentageSector")
    ScpiDtoOut scpiToScpiDtoOut(Scpi scpi);
    List<ScpiDtoOut> scpiToScpiDtoOut(List<Scpi> scpis);
    @Named("firstStatYear")
    default StatYearDtoOut getFirstStatYear(List<StatYear> statYears) {
        return (statYears != null && !statYears.isEmpty())
                ? StatYearDtoOut
                .builder()
                .yearStat(statYears.get(0).getYearStat())
                .distributionRate(statYears.get(0).getDistributionRate())
                .reconstitutionValue(statYears.get(0).getReconstitutionValue())
                .sharePrice(statYears.get(0).getSharePrice())
                .build()
                : null;
    }
}
