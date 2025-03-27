package batch.repository;


import batch.entity.StatYear;
import batch.entity.StatYearId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatYearRepository extends JpaRepository<StatYear, StatYearId> {
    boolean existsByYearStat(StatYearId yearStat);

}
