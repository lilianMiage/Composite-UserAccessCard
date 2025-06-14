package fr.miage.lroux.compositeuseraccesscard.repository;

import fr.miage.lroux.compositeuseraccesscard.dto.AccessCard;
import fr.miage.lroux.compositeuseraccesscard.dto.UserWithAccessCard;

/**
 * Repository interface for managing user access cards.
 * This interface defines methods to retrieve a user with their access card
 * and to create a new access card for a user.
 */
public interface RepoUserAccessCard {

    /**
     * Retrieves a user along with their access card by user ID.
     *
     * @param userId the ID of the user
     * @return UserWithAccessCard object containing user details and access card
     * @throws Exception if an error occurs while retrieving the user or access card
     */
    UserWithAccessCard getUserWithAccessCard(long userId) throws Exception;

    /**
     * Creates a new access card for a user.
     *
     * @param userId the ID of the user
     * @param accessCard the AccessCard object to create
     * @return Created AccessCard object
     * @throws Exception if an error occurs while creating the access card
     */
    AccessCard createAccessCard(long userId,AccessCard accessCard) throws Exception;
}
