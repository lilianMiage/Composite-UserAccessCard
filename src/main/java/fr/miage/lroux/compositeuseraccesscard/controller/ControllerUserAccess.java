package fr.miage.lroux.compositeuseraccesscard.controller;

import fr.miage.lroux.compositeuseraccesscard.dto.AccessCard;
import fr.miage.lroux.compositeuseraccesscard.dto.User;
import fr.miage.lroux.compositeuseraccesscard.dto.UserWithAccessCard;
import fr.miage.lroux.compositeuseraccesscard.repository.RepoUserAccessCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for managing user access cards.
 * Provides endpoints to retrieve user information along with their access card
 * and to create a new access card for a user.
 */
@RestController
@RequestMapping("/api/userAccess/")
public class ControllerUserAccess {

    /**
     * Repository for user access card operations.
     */
    @Autowired
    RepoUserAccessCard repoUserAccessCard;

    /**
     * Retrieves a user along with their access card by user ID.
     *
     * @param userId the ID of the user
     * @return UserWithAccessCard object containing user details and access card
     * @throws Exception if an error occurs while retrieving the user or access card
     */
    @GetMapping("{userId}")
    public UserWithAccessCard getUserWithAccessCard(@PathVariable long userId) throws Exception {
        return repoUserAccessCard.getUserWithAccessCard(userId);
    }

    /**
     * Creates a new access card for a user.
     *
     * @param userId the ID of the user
     * @param accessCard the AccessCard object to create
     * @return Created AccessCard object
     * @throws Exception if an error occurs while creating the access card
     */
    @PostMapping("{userId}")
    public AccessCard createAccessCard(@PathVariable("userId") Long userId, @RequestBody AccessCard accessCard) throws Exception {
       return repoUserAccessCard.createAccessCard(userId,accessCard);
    }
}
