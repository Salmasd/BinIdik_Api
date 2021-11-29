package ma.ensate.binidik.controller;

import ma.ensate.binidik.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/demande")
public class ImageController {
    @Autowired
    private ImageRepository imageRepository;

}
