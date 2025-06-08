package fr.miage.lroux.compositeuseraccesscard.repository;

import fr.miage.lroux.compositeuseraccesscard.dto.AccessCard;
import fr.miage.lroux.compositeuseraccesscard.dto.UserWithAccessCard;

public interface RepoUserAccessCard {

    UserWithAccessCard getUserWithAccessCard(long userId) throws Exception;

    AccessCard createAccessCard(long userId,AccessCard accessCard) throws Exception;
}
