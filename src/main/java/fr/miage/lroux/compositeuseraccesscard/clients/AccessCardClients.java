package fr.miage.lroux.compositeuseraccesscard.clients;

import fr.miage.lroux.compositeuseraccesscard.dto.AccessCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("accesscard")
public interface AccessCardClients {

    /**
     * Get access card by user ID
     * @param userId the user ID
     * @return AccessCard object
     */
    @RequestMapping(method = RequestMethod.GET, value = "/api/accessCard/user/{userId}", produces = "application/json")
    AccessCard getAccessCardByUserId(@PathVariable long userId);

    /**
     * Create a new access card
     * @param accessCard the AccessCard object to create
     * @return Created AccessCard object
     */
    @RequestMapping(method = RequestMethod.POST, value = "/api/accessCard/create", consumes = "application/json")
    AccessCard createAccessCard(@RequestBody AccessCard accessCard);
}

