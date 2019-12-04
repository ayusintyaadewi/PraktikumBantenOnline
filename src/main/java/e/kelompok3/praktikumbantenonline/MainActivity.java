package e.kelompok3.praktikumbantenonline;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button logout;
    TextView txt_username;
    String user;
    SharedPreferences sharedpreferences;


    public static final String TAG_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_username = (TextView) findViewById(R.id.getUsername);
        logout = (Button) findViewById(R.id.logout);

        sharedpreferences = getSharedPreferences(login.my_shared_preferences, Context.MODE_PRIVATE);

        user = getIntent().getStringExtra(TAG_USERNAME);

        txt_username.setText("" + user);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(login.session_status,false);
                editor.putString(TAG_USERNAME, null);
                editor.commit();

                Intent intent = new Intent(MainActivity.this, login.class);
                finish();
                startActivity(intent);
            }
        });


    }
}
