package fr.miage.lroux.compositeuseraccesscard.clients;

import fr.miage.lroux.compositeuseraccesscard.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("userService")
@Component
public interface UserClients {

    @RequestMapping(method = RequestMethod.GET, value = "/api/user/{id}",produces = "application/json")
    User getUser(@PathVariable long id);
}
