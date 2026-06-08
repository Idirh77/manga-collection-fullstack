package manga_collection.repository;

import manga_collection.model.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaRepository extends JpaRepository<Manga, Long> {
    // Grâce à JpaRepository, Spring génère automatiquement le CRUD (FindAll, Save, Delete...) !
}