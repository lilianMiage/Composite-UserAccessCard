package fr.miage.lroux.compositeuseraccesscard.dto;


/**
 * Represents a user with an associated access card.
 * This class is used to manage users in the composite user access card system.
 */
public class UserWithAccessCard extends User{

    private AccessCard accessCard;

    public UserWithAccessCard(User user,AccessCard accessCard) {
        super(user.getUserId(), user.getLastName(), user.getFirstName());
        this.accessCard = accessCard;
    }

    public void setAccessCard(AccessCard accessCard) {
        this.accessCard = accessCard;
    }

    public AccessCard getAccessCard() {
        return accessCard;
    }
}
