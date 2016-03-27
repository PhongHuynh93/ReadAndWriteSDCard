package dhbk.android.readandwritesdcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class PersonActivity extends AppCompatActivity {
    private DatabaseHandler db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        showData();
    }

    private void showData() {
        db = new DatabaseHandler(this);

        // read all contact
        List<Person> persons = db.getAllContacts();
        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
        for (Person p : persons) {
            TextView txtview = new TextView(this);
            String log = "Id: " + p.getId() + " ,Name: " + p.getName() + " , Email: " + p.getEmail();
            txtview.setText(log);
            layout.addView(txtview);
        }
    }
}
