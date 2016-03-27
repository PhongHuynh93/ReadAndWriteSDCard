package dhbk.android.readandwritesdcard;

/**
 * Created by huynhducthanhphong on 3/27/16.
 */
public class Person {
    private final String name;
    private final String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
