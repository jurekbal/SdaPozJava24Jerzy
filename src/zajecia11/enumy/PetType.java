package zajecia11.enumy;

public enum PetType {

    DOG("woof woof"), //
    CAT("miau"), //
    FISH("?"), //
    RABBIT("wiii"),//
    COW("muuu");

    private String sound;

    //kondtruktor, musi być private (domyślnie)
    PetType(String sound) {
        this.sound = sound;
    }

    public void giveSound() {
        System.out.println(sound);
    }

    public static PetType find(String input) {
        for( PetType petType : values()) {
            if (petType.sound.equals(input)) {
                return petType;
            }
        }
        return null;
    }

}
