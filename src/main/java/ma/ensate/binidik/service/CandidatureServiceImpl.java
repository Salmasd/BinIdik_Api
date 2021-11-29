package ma.ensate.binidik.service;

import ma.ensate.binidik.model.Candidature;
import ma.ensate.binidik.repository.CandidatureRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class CandidatureServiceImpl  implements  CandidatureService {

    @Autowired
    private CandidatureRepository candidaturerepository;

    @Override
    public Candidature saveCandidature(Candidature candidature) {
        return candidaturerepository.save(candidature);
    }

    @Override
    public List<Candidature> getAllCandidature() {
        return candidaturerepository.findAll();
    }

    @Override
    public Optional<Candidature> findById(int id) {
        return candidaturerepository.findById(id);
    }

    @Override
    public Candidature addCandidature(Candidature candidature) {
        return candidaturerepository.save(candidature);
    }

    @Override
    public void removeCandidature(Integer id) {
       candidaturerepository.deleteById(id);

    }

    @Override
    public long getCountOfCandidature() {
        long count = candidaturerepository.count();
        return count;
    }
}
