package ma.ensate.binidik.service;

import ma.ensate.binidik.model.Demande;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public interface DemandeService {

    public Demande saveDemande(Demande demande);
    public List<Demande> getAllDemande();
    Optional<Demande> findById(int id);
    public Demande addDemande(Demande demande);
    public void removeDemande(Integer id);
    public long getCountOfDemandes();
    public List<Demande> getDemandeByUser(Integer id);
    public Demande addDemande(Demande demande, MultipartFile[] files);
    public Demande getDemande(Integer id);
    public void updateStatut(Integer id) ;

}
