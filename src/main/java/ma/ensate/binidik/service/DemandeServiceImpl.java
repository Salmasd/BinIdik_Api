package ma.ensate.binidik.service;

import ma.ensate.binidik.model.Demande;
import ma.ensate.binidik.model.Image;
import ma.ensate.binidik.repository.DemandeRepository;
import ma.ensate.binidik.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class DemandeServiceImpl implements DemandeService {

    @Autowired
    private DemandeRepository demandeRepository;
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Demande saveDemande(Demande demande) {
        return demandeRepository.save(demande);
    }

    @Override
    public List<Demande> getAllDemande() {
        return demandeRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Optional<Demande> findById(int id) {
        return demandeRepository.findById(id);
    }

    @Override
    public Demande addDemande(Demande demande) { return demandeRepository.save(demande); }

    @Override
    public void removeDemande(Integer id) {
        demandeRepository.deleteById(id);
    }

    @Override
    public long getCountOfDemandes() {
        long count = demandeRepository.count();
        return count;
    }

    @Override
    public List<Demande> getDemandeByUser(Integer id) {
        return demandeRepository.findAllByUser_idOrderByIdDesc(id);
    }

    @Override
    public Demande addDemande(Demande demande, MultipartFile[] files){
        List<Image> images = new ArrayList<>();
        for (MultipartFile file: files) {
            Image image = new Image();
            try {
                image.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            images.add(image);
        }
        Demande insertedDemande = demandeRepository.save(demande);
        int id_demande = insertedDemande.getId();
        for (Image img: images) {

            imageRepository.save(new Image(img.getImage(), id_demande));
        }
        return insertedDemande;
    }

    @Override
    public Demande getDemande(Integer id) {
        Optional<Demande> demande = demandeRepository.findById(id);
        Demande ann = null;
        if(demande.isPresent()){
            ann = demande.get();
        }
        return ann;
    }

    @Override
    public void updateStatut(Integer id) {
        demandeRepository.updatestatut(id,"Terminée");
    }

}
