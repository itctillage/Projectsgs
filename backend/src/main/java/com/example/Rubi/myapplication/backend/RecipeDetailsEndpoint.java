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
        name = "recipeDetailsApi",
        version = "v1",
        resource = "recipeDetails",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.Rubi.example.com",
                ownerName = "backend.myapplication.Rubi.example.com",
                packagePath = ""
        )
)
public class RecipeDetailsEndpoint {

    private static final Logger logger = Logger.getLogger(RecipeDetailsEndpoint.class.getName());

    /**
     * This method gets the <code>RecipeDetails</code> object associated with the specified <code>id</code>.
     *
     * @param id The id of the object to be returned.
     * @return The <code>RecipeDetails</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getRecipeDetails")
    public RecipeDetails getRecipeDetails(@Named("id") Long id) {
        // TODO: Implement this function
        logger.info("Calling getRecipeDetails method");
        return null;
    }

    /**
     * This inserts a new <code>RecipeDetails</code> object.
     *
     * @param recipeDetails The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertRecipeDetails")
    public RecipeDetails insertRecipeDetails(RecipeDetails recipeDetails) {
        // TODO: Implement this function
        logger.info("Calling insertRecipeDetails method");
        return recipeDetails;
    }
}