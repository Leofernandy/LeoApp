    package com.example.leoapp;

    import android.os.Bundle;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;

    import androidx.activity.EdgeToEdge;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;

    public class CalculatorActivity extends AppCompatActivity {
        Button btnTambah, btnKali, btnBagi;
        EditText etnA, etnB;
        TextView txvHasil;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_calculator);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

            btnTambah = findViewById(R.id.btnTambah);
            btnKali = findViewById(R.id.btnKali);
            btnBagi = findViewById(R.id.btnBagi);
            etnA = findViewById(R.id.etnA);
            etnB = findViewById(R.id.etnB);
            txvHasil = findViewById(R.id.txvHasil);

            btnTambah.setOnClickListener(v -> {
                int a = getInput(etnA);
                int b = getInput(etnB);
                int hasil = a + b;
                txvHasil.setText(String.valueOf(hasil));
            });

            btnKali.setOnClickListener(v -> {
                int a = getInput(etnA);
                int b = getInput(etnB);
                int hasil = a * b;
                txvHasil.setText(String.valueOf(hasil));
            });

            btnBagi.setOnClickListener(v -> {
                int a = getInput(etnA);
                int b = getInput(etnB);
                if (b != 0) {
                    double hasil = (double) a / b;
                    txvHasil.setText(String.valueOf(hasil));
                } else {
                    txvHasil.setText("Tidak bisa dibagi 0");
                }
            });
        }

        // Fungsi untuk ambil nilai dari EditText
        private int getInput(EditText editText) {
            String input = editText.getText().toString();
            if (input.isEmpty()) return 0;
            return Integer.parseInt(input);
        }
    }