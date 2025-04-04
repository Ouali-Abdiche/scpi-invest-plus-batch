package batch.config.writer;


import batch.dto.BatchDataDto;
import batch.service.BatchService;
import batch.service.LocationService;
import batch.service.SectorService;
import batch.service.StatYearService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class BatchItemWriter implements ItemWriter<BatchDataDto> {

    private final BatchService batchService;
    private final LocationService locationService;
    private final SectorService sectorService;
    private final StatYearService statYearService;

    @Transactional
    @Override
    public void write(Chunk<? extends BatchDataDto> items) {
        if (items.isEmpty()) return;

        List<BatchDataDto> batchDataList = items.getItems().stream()
                .map(BatchDataDto.class::cast)
                .toList();

        batchService.saveOrUpdateBatchData(batchDataList);

        batchDataList.forEach(batchData -> {
            if (batchData.getLocations() != null) {
                locationService.saveLocations(batchData.getLocations());
            }
            if (batchData.getSectors() != null) {
                sectorService.saveSectors(batchData.getSectors());
            }
            if (batchData.getStatYears() != null) {
                statYearService.saveStatYears(batchData.getStatYears());
            }
        });
        log.info("{} SCPI enregistrées en base", batchDataList.size());
    }
}
