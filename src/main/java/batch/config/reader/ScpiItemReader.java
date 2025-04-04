package batch.config.reader;


import batch.dto.ScpiDto;
import batch.enums.ScpiField;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class ScpiItemReader {

    @Bean
    public FlatFileItemReader<ScpiDto> reader() {
        return new FlatFileItemReaderBuilder<ScpiDto>()
                .name("scpiRequestItemReader")
                .resource(new ClassPathResource("scpi.csv"))
                .encoding(StandardCharsets.UTF_8.name())
                .linesToSkip(1)
                .delimited()
                .delimiter(",")
                .names(
                        ScpiField.NOM.getColumnName(),
                        ScpiField.TAUX_DISTRIBUTION.getColumnName(),
                        ScpiField.MINIMUM_SOUSCRIPTION.getColumnName(),
                        ScpiField.LOCALISATION.getColumnName(),
                        ScpiField.SECTEURS.getColumnName(),
                        ScpiField.PRIX_PART.getColumnName(),
                        ScpiField.CAPITALISATION.getColumnName(),
                        ScpiField.GERANT.getColumnName(),
                        ScpiField.FRAIS_SOUSCRIPTION.getColumnName(),
                        ScpiField.FRAIS_GESTION.getColumnName(),
                        ScpiField.DELAI_JOUISSANCE.getColumnName(),
                        ScpiField.FREQUENCE_LOYERS.getColumnName(),
                        ScpiField.VALEUR_RECONSTITUTION.getColumnName(),
                        ScpiField.IBAN.getColumnName(),
                        ScpiField.BIC.getColumnName(),
                        ScpiField.DECOTE_DEMEMBREMENT.getColumnName(),
                        ScpiField.DEMEMBREMENT.getColumnName(),
                        ScpiField.CASHBACK.getColumnName(),
                        ScpiField.VERSEMENT_PROGRAMME.getColumnName(),
                        ScpiField.PUBLICITE.getColumnName()
                )

                .fieldSetMapper(new ScpiRequestFieldSetMapper())
                .build();
    }

}