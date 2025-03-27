package batch.mapper;


import batch.dto.LocationDtoOut;
import batch.entity.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationDtoOut toDTO(Location location);
    Location toEntity(LocationDtoOut locationDTO);
}
