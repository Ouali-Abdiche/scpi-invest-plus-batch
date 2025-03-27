package batch.mapper;


import batch.dto.StatYearDtoOut;
import batch.entity.StatYear;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatYearMapper {
    StatYearDtoOut toDTO(StatYear statYear);
}
