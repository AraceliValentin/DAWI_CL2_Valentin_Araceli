package pe.edu.i202030295.cl2_valentin_araceli.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.i202030295.cl2_valentin_araceli.entity.FilmCategory;
import jakarta.transaction.Transactional; // Para @Transactional
import org.springframework.data.jpa.repository.Modifying; // Para @Modifying
import org.springframework.data.jpa.repository.Query; // Para @Query
import org.springframework.data.repository.query.Param; // Para @Param

public interface FilmCategoryRepository extends CrudRepository<FilmCategory, Integer>  {
    // Eliminar registros por ID de película
    @Modifying
    @Transactional
    @Query("DELETE FROM FilmCategory fc WHERE fc.film.filmId = :filmId")
    void deleteByFilmId(@Param("filmId") int filmId);
}
