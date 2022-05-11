package michal.ulik.recruitmenttask.model;

import michal.ulik.recruitmenttask.model.enitities.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
}
