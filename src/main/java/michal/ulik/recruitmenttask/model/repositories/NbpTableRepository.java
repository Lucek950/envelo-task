package michal.ulik.recruitmenttask.model.repositories;

import michal.ulik.recruitmenttask.model.enities.NbpTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NbpTableRepository extends JpaRepository<NbpTable, Long> {
}
