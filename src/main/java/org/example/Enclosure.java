package org.example;

public class Enclosure {

    protected String animalType;

    class PachydermEnclosure extends Enclosure{

    }

    class FelineEnclosure extends Enclosure{

    }

    class BirdEnclosure extends Enclosure{

    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

}
