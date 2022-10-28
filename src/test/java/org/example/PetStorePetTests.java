package org.example;

import io.restassured.response.Response;
import org.example.entities.Pet;
import org.example.entities.PetClasses.PetCategory;
import org.example.steps.PetServiceSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class PetStorePetTests {
    @Test
    public void createPetTest() {
        Pet expectedPet = createPet();
        Response actualPet = PetServiceSteps.addNewPet(expectedPet);
        Assert.assertEquals(actualPet.as(Pet.class).getName(), expectedPet.getName());
    }

    @Test
    public void getPetByStatusTest() {
        Response petListResponse = PetServiceSteps.getPetByStatus("available");
        List<Pet> petList = petListResponse.jsonPath().getList("", Pet.class);
        Assert.assertTrue(petList.stream().anyMatch(pet -> pet.getName().equals("doggie")));
    }


    private Pet createPet() {
        Pet createdPet = new Pet();
        LinkedHashMap<String, String> tagMap = new LinkedHashMap<>();
        tagMap.put("id", "");
        tagMap.put("name", "Ruf");
        ArrayList<LinkedHashMap<String, String>> tagArray = new ArrayList<>();
        tagArray.add(tagMap);

        createdPet.setId(1L)
                .setCategory(new PetCategory().setId(2L).setName("dog"))
                .setName("Rufus")
                .setPhotoUrls(new ArrayList<>())
                .setTags(tagArray)
                .setStatus("alive");
        return createdPet;
    }
}
