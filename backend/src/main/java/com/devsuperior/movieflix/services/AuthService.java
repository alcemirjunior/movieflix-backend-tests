package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.services.exceptions.ForbiddenException;
import com.devsuperior.movieflix.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public User authenticated () {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName(); //pega o nome do usuario reconhecido pelo spring security
            return userRepository.findByEmail(username);
        }
        catch (Exception e){
            throw new UnauthorizedException("Invalid user");
        }
    }
    public void validateRole(){
        User user = authenticated();
        if (!user.hasHole("ROLE_VISITOR") && !user.hasHole("ROLE_MEMBER")){
            throw new ForbiddenException("Access denied");
        }
    }
    public User validateMember(){
        User user = authenticated();
        if (!user.hasHole("ROLE_MEMBER")){
            throw new ForbiddenException("Access denied");
        }
        return user;
    }

}
