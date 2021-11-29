package ma.ensate.binidik.repository;

import ma.ensate.binidik.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Integer> {
    public List<Demande> findAllByUser_idOrderByIdDesc(Integer id);
    public List<Demande> findAllByOrderByIdDesc();

    @Modifying()
    @Query(value = "update Demandes u set u.statut = :statut where u.id = :id", nativeQuery = true)
    @Transactional
    void updatestatut(@Param(value = "id") Integer id, @Param(value = "statut") String statut);
}
