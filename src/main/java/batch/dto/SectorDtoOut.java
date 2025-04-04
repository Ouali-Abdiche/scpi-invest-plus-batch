package batch.dto;

import batch.entity.SectorId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SectorDtoOut {
    private SectorId id;
    private BigDecimal sectorPercentage;
}
