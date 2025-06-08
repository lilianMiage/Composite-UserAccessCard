package fr.miage.lroux.compositeuseraccesscard.service;

import feign.FeignException;
import fr.miage.lroux.compositeuseraccesscard.clients.AccessCardClients;
import fr.miage.lroux.compositeuseraccesscard.clients.UserClients;
import fr.miage.lroux.compositeuseraccesscard.dto.AccessCard;
import fr.miage.lroux.compositeuseraccesscard.dto.User;
import fr.miage.lroux.compositeuseraccesscard.dto.UserWithAccessCard;
import fr.miage.lroux.compositeuseraccesscard.repository.RepoUserAccessCard;
import org.springframework.stereotype.Component;

@Component
public class ServiceUserAccessCard implements RepoUserAccessCard {

    private final AccessCardClients accessCardClients;

    private final UserClients userClients;

    public ServiceUserAccessCard(AccessCardClients accessCardClients, UserClients userClients) {
        this.accessCardClients = accessCardClients;
        this.userClients = userClients;
    }
    @Override
    public UserWithAccessCard getUserWithAccessCard(long userId) throws Exception {
        User user = null;
        try {
            user = userClients.getUser(userId);
        }catch (FeignException.NotFound e){
            throw new Exception();
        }
        AccessCard accessCard = accessCardClients.getAccessCard(user.getUserId());

        return new UserWithAccessCard(user,accessCard);
    }

    @Override
    public AccessCard createAccessCard(long userId, AccessCard accessCard) throws Exception {
        User user = null;

        try{
            user = userClients.getUser(userId);
        }catch (FeignException.NotFound e){
            throw new Exception();
        }
        AccessCard accessCard1 = null;
        try {
            accessCard.setUserId(user.getUserId());
            accessCard1 = accessCardClients.createAccessCard(accessCard);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return accessCard1;
    }
}
