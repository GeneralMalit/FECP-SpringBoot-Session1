package org.example.buildings;

public class Enclosure {

    private String animalType;
    private String species;

    public Enclosure(String species, String animalType){
        this.species = species;
        this.animalType = animalType;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

}
