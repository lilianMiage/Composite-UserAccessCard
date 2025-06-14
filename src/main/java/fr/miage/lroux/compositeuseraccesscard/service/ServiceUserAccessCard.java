package fr.miage.lroux.compositeuseraccesscard.service;

import feign.FeignException;
import fr.miage.lroux.compositeuseraccesscard.clients.AccessCardClients;
import fr.miage.lroux.compositeuseraccesscard.clients.UserClients;
import fr.miage.lroux.compositeuseraccesscard.dto.AccessCard;
import fr.miage.lroux.compositeuseraccesscard.dto.User;
import fr.miage.lroux.compositeuseraccesscard.dto.UserWithAccessCard;
import fr.miage.lroux.compositeuseraccesscard.repository.RepoUserAccessCard;
import org.springframework.stereotype.Component;

/**
 * ServiceUserAccessCard is a service that manages user access cards.
 * It interacts with external services to retrieve user and access card information.
 */
@Component
public class ServiceUserAccessCard implements RepoUserAccessCard {

    /**
     * Clients for accessing user and access card services.
     */
    private final AccessCardClients accessCardClients;

    private final UserClients userClients;

    public ServiceUserAccessCard(AccessCardClients accessCardClients, UserClients userClients) {
        this.accessCardClients = accessCardClients;
        this.userClients = userClients;
    }

    /**
     * Retrieves a user along with their access card by user ID.
     *
     * @param userId the ID of the user
     * @return UserWithAccessCard object containing user details and access card
     * @throws Exception if an error occurs while retrieving the user or access card
     */
    @Override
    public UserWithAccessCard getUserWithAccessCard(long userId) throws Exception {
        User user = checkUserExistOrThrow(userId);
        AccessCard accessCard = getAccessCardByIdOrThrow(userId);

        return new UserWithAccessCard(user,accessCard);
    }

    /**
     * Creates a new access card for a user.
     *
     * @param userId the ID of the user
     * @param accessCardBody the AccessCard object to create
     * @return Created AccessCard object
     * @throws Exception if an error occurs while creating the access card
     */
    @Override
    public AccessCard createAccessCard(long userId, AccessCard accessCardBody) throws Exception {
        User user = checkUserExistOrThrow(userId);

        accessCardBody.setUserId(user.getUserId());
        AccessCard accessCardReturn = createAccessCardOrThrow(accessCardBody);

        updateUserAccessCardIdOrThrow(userId, accessCardReturn.getAccessCardId());

        return accessCardReturn;
    }

    /**
     * Checks if a user exists by user ID and throws an exception if not found.
     *
     * @param userId the ID of the user to check
     * @return User object if found
     * @throws Exception if the user does not exist
     */
    private User checkUserExistOrThrow(long userId) throws Exception {
        try {
            return userClients.getUser(userId);
        } catch (FeignException.NotFound e) {
            throw new Exception("User not found with id: " + userId);
        }
    }

    /**
     * Creates a new access card and throws an exception if the creation fails.
     *
     * @param accessCard the AccessCard object to create
     * @return Created AccessCard object
     * @throws RuntimeException if the creation fails
     */
    private AccessCard createAccessCardOrThrow(AccessCard accessCard) {
        try {
            return accessCardClients.createAccessCard(accessCard);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create access card", e);
        }
    }

    /**
     * Updates the user's access card ID and throws an exception if the update fails.
     *
     * @param userId the ID of the user to update
     * @param accessCardId the new access card ID to set for the user
     * @throws RuntimeException if the update fails
     */
    private void updateUserAccessCardIdOrThrow(long userId, long accessCardId) {
        try {
            userClients.updateAccessCardId(userId, accessCardId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update user with access card ID", e);
        }
    }

    /**
     * Retrieves an access card by user ID and throws an exception if not found.
     *
     * @param userId the ID of the user associated with the access card
     * @return AccessCard object if found
     * @throws Exception if the access card does not exist for the given user ID
     */
    private AccessCard getAccessCardByIdOrThrow(long userId) throws Exception {
        try {
            return accessCardClients.getAccessCardByUserId(userId);
        } catch (FeignException.NotFound e) {
            throw new Exception("Access card not found for user with id: " + userId);
        }
    }
}
