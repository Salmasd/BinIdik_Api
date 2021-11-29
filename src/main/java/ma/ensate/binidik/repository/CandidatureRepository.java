package ma.ensate.binidik.repository;

import ma.ensate.binidik.model.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, Integer> {
}
