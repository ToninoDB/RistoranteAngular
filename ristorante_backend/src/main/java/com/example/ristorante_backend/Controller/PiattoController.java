package com.example.ristorante_backend.Controller;
import java.util.List;
import com.example.ristorante_backend.Model.Piatto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.ristorante_backend.Service.PiattoService;

@RestController
@RequestMapping("/ristorante")
@CrossOrigin(origins = "http://localhost:4200")
public class PiattoController {
    @Autowired
    private PiattoService piattoService;

    @GetMapping 
    public List<Piatto> getAllPiatti() {
        return piattoService.getAllPiatti();
    }

    @PostMapping
    public Piatto addPiatto(@RequestBody Piatto piatto) {
        return piattoService.addPiatto(piatto);
    }

    @DeleteMapping("/{id}")
    public void deletePiatto(@PathVariable Long id) {
        piattoService.deletePiatto(id);
    }
}
