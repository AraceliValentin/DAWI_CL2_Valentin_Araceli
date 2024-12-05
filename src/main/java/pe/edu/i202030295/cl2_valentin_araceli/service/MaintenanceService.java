package pe.edu.i202030295.cl2_valentin_araceli.service;


import pe.edu.i202030295.cl2_valentin_araceli.dto.FilmDetailDto;
import pe.edu.i202030295.cl2_valentin_araceli.dto.FilmDto;

import java.util.List;

public interface MaintenanceService {

    List<FilmDto> getAllFilms();
    FilmDetailDto getFilmById(int id);
    Boolean updateFilm(FilmDetailDto filmDetailDto);
    Boolean deleteFilm(int id);
    FilmDetailDto createFilm(FilmDetailDto filmDetailDto);
}