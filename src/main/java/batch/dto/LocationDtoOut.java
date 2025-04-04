package batch.dto;

import batch.entity.LocationId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LocationDtoOut {
    private LocationId id;
    private BigDecimal countryPercentage;
}
