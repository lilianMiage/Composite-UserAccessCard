package fr.miage.lroux.compositeuseraccesscard.dto;

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
