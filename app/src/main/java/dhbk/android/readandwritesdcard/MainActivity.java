package dhbk.android.readandwritesdcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }

    public void readData(View view) {
    }
}