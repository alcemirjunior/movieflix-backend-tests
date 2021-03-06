package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAllPaged(Long genreId, Pageable pageable){

        authService.validateRole();

        Genre genre = (genreId == 0 ) ? null : genreRepository.getOne(genreId);
        Page<Movie> page = repository.find(genre, pageable);
        if (genreId == 0 ){
            return page.map(x -> new MovieDTO(x));
        }
        else {
            GenreDTO genreDTO = new GenreDTO(genre);
            return page.map(x -> new MovieDTO(x, genreDTO));
        }
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id){

        authService.validateRole();

        Optional<Movie> obj = repository.findById(id);
        Movie entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity Not Found!"));
        return new MovieDTO(entity);
    }
}
