package batch.config.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
@RequiredArgsConstructor
@EnableScheduling
public class BatchJobScheduler implements CommandLineRunner {

    private final JobLauncher jobLauncher;
    private final Job scpiJob;

    @Override
    public void run(String... args) throws Exception {
        runJob();
    }

    public void runJob() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();

            log.info("Lancement du job SCPI à {}", getCurrentTime());
            jobLauncher.run(scpiJob, jobParameters);
            log.info("Job SCPI exécuté avec succès à {}", getCurrentTime());

        } catch (Exception e) {
            log.error("Erreur lors de l'exécution du job SCPI : {}", e.getMessage(), e);
        }
    }

    private String getCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
