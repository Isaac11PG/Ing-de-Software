package mx.ipn.com.holaspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HolaController {

    @GetMapping("/")
    public String home() {
        return "index"; // Esto buscará index.html en /templates/
    }
}
