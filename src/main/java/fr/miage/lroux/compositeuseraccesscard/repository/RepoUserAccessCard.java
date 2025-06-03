package fr.miage.lroux.compositeuseraccesscard.repository;

import fr.miage.lroux.compositeuseraccesscard.dto.AccessCard;
import fr.miage.lroux.compositeuseraccesscard.dto.UserWithAccessCard;

public interface RepoUserAccessCard {

    UserWithAccessCard getUserWithAccessCard(long idUser) throws Exception;

    AccessCard createAccessCard(long idUser,AccessCard accessCard);
}
