package org.example.entities.PetClasses;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PetCategory {
    private long id;
    private String name;
}
