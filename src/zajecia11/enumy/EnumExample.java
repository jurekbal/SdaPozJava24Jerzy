package zajecia11.enumy;

public class EnumExample {
    public static void main(String[] args) {
        PetType type1 = PetType.DOG;
        PetType type2 = PetType.CAT;
        PetType type3 = PetType.DOG;

//        System.out.println(type1 == type2);
//        System.out.println(type1 == type3);
//
//        type1.giveSound();
//        type2.giveSound();
//        type3.giveSound();

        PetType[] petTypes = PetType.values();
        for (PetType s : petTypes){
            s.giveSound();
        }

        PetType pet = PetType.valueOf("COW");
        pet.giveSound();

        PetType petThatGiveMuu = PetType.find("muuu");
        System.out.println(petThatGiveMuu.name());
        System.out.println(petThatGiveMuu.ordinal());

    }

}
