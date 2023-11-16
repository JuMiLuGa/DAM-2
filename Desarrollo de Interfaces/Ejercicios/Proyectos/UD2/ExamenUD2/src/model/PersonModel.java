package model;

public class PersonModel {

    private String name;
    private String roomType;
    private boolean isSmoker;
    private boolean needWifi;

    // Constructor
    public PersonModel(String name, String roomType, boolean isSmoker, boolean needWifi) {
        this.name = name;
        this.roomType = roomType;
        this.isSmoker = isSmoker;
        this.needWifi = needWifi;
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isSmoker() {
        return isSmoker;
    }

    public void setIsSmoker(boolean isSmoker) {
        this.isSmoker = isSmoker;
    }

    public boolean needWifi() {
        return needWifi;
    }

    public void setNeedWifi(boolean needWifi) {
        this.needWifi = needWifi;
    }

    public static PersonModel createPerson(String name, String roomType, boolean isSmoker, boolean needWifi) {
        return new PersonModel(name, roomType, isSmoker, needWifi);
    }

    PersonModel person1 = createPerson("Sandra", "Single", false, true);
    PersonModel person2 = createPerson("Juan", "Single", false, true);
    PersonModel person3 = createPerson("Laura", "Double", true, false);
    PersonModel person4 = createPerson("Manuel", "Double", false, true);
}
