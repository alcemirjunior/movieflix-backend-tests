package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class ReviewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @NotBlank(message = "Campo obrigatório")
    private String text;

    private Long movieId;

    private UserDTO user;

    public ReviewDTO() {
    }

    public ReviewDTO(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public ReviewDTO(Review entity) {
        id = entity.getId();
        text = entity.getText();
        movieId = entity.getMovie().getId();
        user = new UserDTO(entity.getUser());
    }

    public ReviewDTO(Review entity, UserDTO user) {
        this(entity);
        this.user = user;
        movieId= entity.getMovie().getId();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserDTO getUser() {
        return user;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
