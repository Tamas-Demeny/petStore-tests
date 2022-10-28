package org.example.steps;

import io.restassured.response.Response;
import org.example.service.Services;
import org.example.service.uritemplate.UriTemplate;

import static org.example.service.uritemplate.PetPetUri.ADD_PET;
import static org.example.service.uritemplate.PetPetUri.PET_STATUS;

public class PetServiceSteps {
    public static final Services PET_SERVICES = Services.getInstance();

    public static Response addNewPet(Object body) {
        return PET_SERVICES.postRequest(ADD_PET, body);
    }

    public static Response getPetByStatus(String status) {
        return PET_SERVICES.getRequest(new UriTemplate(PET_STATUS.getUri() + status));
    }

}
