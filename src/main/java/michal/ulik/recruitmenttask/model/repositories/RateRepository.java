package michal.ulik.recruitmenttask.model.repositories;

import michal.ulik.recruitmenttask.model.enities.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
}
