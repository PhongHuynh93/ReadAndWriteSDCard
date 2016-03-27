package dhbk.android.readandwritesdcard;

/**
 * Created by huynhducthanhphong on 3/27/16.
 */
public class Person {
    private String name;
    private String email;
    private int id;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
        this.id = 0;
    }

    public Person() {
        this.name = "";
        this.email = "";
        this.id = 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
