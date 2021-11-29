package ma.ensate.binidik.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ma.ensate.binidik.model.Demande;
import ma.ensate.binidik.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/demande")
public class DemandeController {

    @Autowired
    private DemandeService demandeService;

    @PostMapping("/save")
    public String add(@RequestBody Demande demande){
        demandeService.saveDemande(demande);
        return "Saved";
    }


    @GetMapping("get")
    public List<Demande> get(){
        return demandeService.getAllDemande();
    }

    @GetMapping("/getdemande/{id}")
    Optional<Demande> getDemande(@PathVariable int id) {

        return demandeService.findById(id);
    }

    @PostMapping("/demande")
    public Demande addDemande(Demande demande){
        return demandeService.addDemande(demande);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        demandeService.removeDemande(id);
    }

    @GetMapping("/count")
    public long countDemande() {
        long count = demandeService.getCountOfDemandes();
        return count;
    }
    @GetMapping("mesdemandes/{id}")
    public List<Demande> getByUser(@PathVariable Integer id){
        return demandeService.getDemandeByUser(id);
    }

    @PostMapping(path = "/demande/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Demande save(@RequestPart String demande, @RequestPart MultipartFile[] files) {

        Demande demandeOb = new Demande();
        try {
            demandeOb  = new ObjectMapper().readValue(demande, Demande.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return demandeService.addDemande(demandeOb, files);
    }

    @GetMapping("demande/{id}")
    public Demande getDemande(@PathVariable Integer id) { return demandeService.getDemande(id);}

    @PutMapping("/update/{id}")
    public void updateStatut(@PathVariable  Integer id) {
       demandeService.updateStatut(id);
    }



}
