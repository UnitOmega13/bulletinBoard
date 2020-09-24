package utils;

public class IdGenerator {
    private static Integer generatedID = 1;

    public static int generateId() {
        return generatedID++;
    }
}
