package org.example.entities;

import lombok.Data;
import lombok.experimental.Accessors;
import org.example.entities.PetClasses.PetCategory;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@Data
@Accessors(chain = true)
public class Pet {
    private Long id;
    private PetCategory category;
    private String name;
    private ArrayList<String> photoUrls;
    private ArrayList<LinkedHashMap<String, String>> tags;
    private String status;
}
