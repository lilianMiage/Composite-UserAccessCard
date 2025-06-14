package fr.miage.lroux.compositeuseraccesscard.clients;

import fr.miage.lroux.compositeuseraccesscard.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("utilisateur")
public interface UserClients {

    /**
     * Get user by ID
     * @param id the user ID
     * @return User object
     */
    @RequestMapping(method = RequestMethod.GET, value = "/api/user/{id}",produces = "application/json")
    User getUser(@PathVariable long id);

    /**
     * Create a new user
     * @param user the User object to create
     * @return Created User object
     */
    @RequestMapping(method = RequestMethod.POST, value = "/api/user/create", consumes = "application/json")
    User createUser(@RequestBody User user);

    /**
     * Update the access card ID for a user
     * @param id the user ID
     * @param accessCardId the access card ID to associate with the user
     * @return Updated User object
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/api/user/{id}", consumes = "application/json")
    User updateAccessCardId(@PathVariable long id, @RequestBody long accessCardId);
}
