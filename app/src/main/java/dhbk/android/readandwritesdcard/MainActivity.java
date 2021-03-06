package dhbk.android.readandwritesdcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private DatabaseHandler db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHandler(this);
    }


    public void saveData(View view) throws IOException {
        EditText name = (EditText) findViewById(R.id.txtname);
        EditText pwd = (EditText) findViewById(R.id.txtemail);

        File myDir = new File("/sdcard/postion");
        myDir.mkdirs();
        FileWriter out = new FileWriter(new File(myDir, "saved.txt"), true);

        out.write(name.getText().toString() + "\n");
        out.write(pwd.getText().toString() + "\n");
        out.close();

        // write data to db
        saveToDB(name.getText().toString(), pwd.getText().toString());
        name.setText("");
        pwd.setText("");
    }

    public void readData(View view) throws IOException {
        BufferedReader in = null;
        File myDir = new File("/sdcard/postion");
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try {
            in = new BufferedReader(new FileReader(new File(myDir, "saved.txt")));
            while ((line = in.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            in.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        TextView show = (TextView) findViewById(R.id.txtshow);
        show.setText(stringBuilder.toString());

    }

    public void showDatabase(View view) {
        Intent intent = new Intent(this, PersonActivity.class);
        startActivity(intent);
    }

    private void saveToDB(String name, String email) {
        db.addContact(new Person(name, email));
    }
}