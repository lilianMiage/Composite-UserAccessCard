package fr.miage.lroux.compositeuseraccesscard.controller;

import fr.miage.lroux.compositeuseraccesscard.dto.AccessCard;
import fr.miage.lroux.compositeuseraccesscard.dto.User;
import fr.miage.lroux.compositeuseraccesscard.dto.UserWithAccessCard;
import fr.miage.lroux.compositeuseraccesscard.repository.RepoUserAccessCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userAccess/")
public class ControllerUserAccess {

    @Autowired
    RepoUserAccessCard repoUserAccessCard;

    @GetMapping("{userId}")
    public UserWithAccessCard getUserWithAccessCard(@PathVariable long userId) throws Exception {
        return repoUserAccessCard.getUserWithAccessCard(userId);
    }

    @PostMapping("{userId}")
    public AccessCard createAccessCard(@PathVariable("userId") Long userId, @RequestBody AccessCard accessCard) throws Exception {
       return repoUserAccessCard.createAccessCard(userId,accessCard);
    }
}
