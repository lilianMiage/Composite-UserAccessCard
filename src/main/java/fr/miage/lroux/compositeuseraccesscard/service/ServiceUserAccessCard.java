package fr.miage.lroux.compositeuseraccesscard.service;

import feign.FeignException;
import fr.miage.lroux.compositeuseraccesscard.clients.AccessCardClients;
import fr.miage.lroux.compositeuseraccesscard.clients.UserClients;
import fr.miage.lroux.compositeuseraccesscard.dto.AccessCard;
import fr.miage.lroux.compositeuseraccesscard.dto.User;
import fr.miage.lroux.compositeuseraccesscard.dto.UserWithAccessCard;
import fr.miage.lroux.compositeuseraccesscard.repository.RepoUserAccessCard;
import org.springframework.beans.factory.annotation.Autowired;
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
    public UserWithAccessCard getUserWithAccessCard(long idUser) throws Exception {
        User user = null;
        try {
            user = userClients.getUser(idUser);
        }catch (FeignException.NotFound e){
            throw new Exception();
        }
        AccessCard accessCard = accessCardClients.getAccessCard(user.getUserId());

        return new UserWithAccessCard(user,accessCard);
    }

    @Override
    public AccessCard createAccessCard(long idUser, AccessCard accessCard) {
        return null;
    }
}
