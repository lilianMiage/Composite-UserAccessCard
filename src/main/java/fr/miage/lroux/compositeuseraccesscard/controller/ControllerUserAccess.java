package fr.miage.lroux.compositeuseraccesscard.controller;

import fr.miage.lroux.compositeuseraccesscard.dto.UserWithAccessCard;
import fr.miage.lroux.compositeuseraccesscard.repository.RepoUserAccessCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/userAccess/")
public class ControllerUserAccess {

    @Autowired
    RepoUserAccessCard repoUserAccessCard;

    @GetMapping("{idUser}")
    public UserWithAccessCard getUserWithAccessCard(@PathVariable long idUser) throws Exception {
        return repoUserAccessCard.getUserWithAccessCard(idUser);
    }
}
