package online.huihua.suzhou.com.huihuaapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import online.huihua.suzhou.com.huihuaapp.R;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.text1)
    TextView text1;
    @BindView(R.id.text32)
    TextView text32;
    @BindView(R.id.tex33)
    TextView tex33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "33344", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
