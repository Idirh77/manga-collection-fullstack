package manga_collection.controller;

import manga_collection.model.Manga;
import manga_collection.repository.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mangas")
@CrossOrigin(origins = "*") // Permet à React de communiquer avec l'API sans blocage CORS
public class MangaController {

    @Autowired
    private MangaRepository mangaRepository;

    // 1. LIRE TOUS LES MANGAS (GET http://localhost:8080/api/mangas)
    @GetMapping
    public List<Manga> getAllMangas() {
        return mangaRepository.findAll();
    }

    // 2. AJOUTER UN MANGA (POST http://localhost:8080/api/mangas)
    @PostMapping
    public Manga createManga(@RequestBody Manga manga) {
        return mangaRepository.save(manga);
    }

    // 3. SUPPRIMER UN MANGA (DELETE http://localhost:8080/api/mangas/{id})
    @DeleteMapping("/{id}")
    public void deleteManga(@PathVariable Long id) {
        mangaRepository.deleteById(id);
    }
}