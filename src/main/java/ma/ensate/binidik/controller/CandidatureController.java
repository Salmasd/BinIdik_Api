package ma.ensate.binidik.controller;

import ma.ensate.binidik.model.Candidature;
import ma.ensate.binidik.service.CandidatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/candidature")
public class CandidatureController {

    @Autowired
    private CandidatureService candidatureservice;

    @GetMapping("/getAll")
    public List<Candidature> get(){
        return candidatureservice.getAllCandidature();
    }

    @PostMapping("/save")
    public Candidature saveCandidature(@RequestBody Candidature candidature){
        return candidatureservice.saveCandidature(candidature);
    }
    @GetMapping("/count")
    public long countCandidature() {
        long count = candidatureservice.getCountOfCandidature();
        return count;
    }
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        candidatureservice.removeCandidature(id);
    }
    @GetMapping("/getcandidature/{id}")
    Optional<Candidature> getCandidature(@PathVariable int id) {

        return candidatureservice.findById(id);
    }



}
