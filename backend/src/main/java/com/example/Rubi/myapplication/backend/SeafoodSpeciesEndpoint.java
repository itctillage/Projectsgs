package com.example.Rubi.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.logging.Logger;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "seafoodSpeciesApi",
        version = "v1",
        resource = "seafoodSpecies",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.Rubi.example.com",
                ownerName = "backend.myapplication.Rubi.example.com",
                packagePath = ""
        )
)
public class SeafoodSpeciesEndpoint {

    private static final Logger logger = Logger.getLogger(SeafoodSpeciesEndpoint.class.getName());

    /**
     * This method gets the <code>SeafoodSpecies</code> object associated with the specified <code>id</code>.
     *
     * @param id The id of the object to be returned.
     * @return The <code>SeafoodSpecies</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getSeafoodSpecies")
    public SeafoodSpecies getSeafoodSpecies(@Named("id") Long id) {
        // TODO: Implement this function
        logger.info("Calling getSeafoodSpecies method");
        return null;
    }

    /**
     * This inserts a new <code>SeafoodSpecies</code> object.
     *
     * @param seafoodSpecies The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertSeafoodSpecies")
    public SeafoodSpecies insertSeafoodSpecies(SeafoodSpecies seafoodSpecies) {
        // TODO: Implement this function
        logger.info("Calling insertSeafoodSpecies method");
        return seafoodSpecies;
    }
}