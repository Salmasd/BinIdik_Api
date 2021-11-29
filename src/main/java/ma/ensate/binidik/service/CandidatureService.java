package ma.ensate.binidik.service;

import ma.ensate.binidik.model.Candidature;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public interface CandidatureService {
    public Candidature saveCandidature(Candidature candidature);
    public List<Candidature> getAllCandidature();
    Optional<Candidature> findById(int id);
    public Candidature addCandidature(Candidature candidature);
    public void removeCandidature(Integer id);
    public long getCountOfCandidature();

}
