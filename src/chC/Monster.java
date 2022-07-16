package chC;

class Monster {
    private int health;
    private Breed breed;

    public Monster(Breed breed) {
        this.health = breed.getHealth();
    }
}
