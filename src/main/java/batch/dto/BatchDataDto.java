package batch.dto;


import batch.entity.Location;
import batch.entity.Scpi;
import batch.entity.Sector;
import batch.entity.StatYear;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatchDataDto {
    private ScpiDto scpiDto;
    private Scpi scpi;
    private List<Location> locations;
    private List<Sector> sectors;
    private List<StatYear> statYears;
}

