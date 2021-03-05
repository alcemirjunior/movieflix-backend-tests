package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private AuthService authService;


    @Transactional
    public ReviewDTO insert(ReviewDTO reviewDto) {

        User user = authService.validateMember();

        Review reviewEntity = new Review();
        Movie movie = movieRepository.getOne(reviewDto.getMovieId());
        UserDTO userDTO = new UserDTO(user);

        reviewEntity.setMovie(movie);
        reviewEntity.setUser(user);
        reviewEntity.setText(reviewDto.getText());

        movie.getReviews().add(reviewEntity);

        movieRepository.save(movie);
        repository.save(reviewEntity);

        return new ReviewDTO(reviewEntity, userDTO);
    }

}
