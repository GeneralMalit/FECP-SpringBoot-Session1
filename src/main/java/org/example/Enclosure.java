package org.example;

public class Enclosure {

    private String animalType;
    private String species;

    public Enclosure(String species, String animalType){
        this.species = species;
        this.animalType = animalType;
    }

    class PachydermEnclosure extends Enclosure{
        public PachydermEnclosure(String species, String animalType) {
            super(species, animalType);
        }
    }

    class FelineEnclosure extends Enclosure{
        public FelineEnclosure(String species, String animalType) {
            super(species, animalType);
        }
    }

    class BirdEnclosure extends Enclosure{
        public BirdEnclosure(String species, String animalType) {
            super(species, animalType);
        }
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
