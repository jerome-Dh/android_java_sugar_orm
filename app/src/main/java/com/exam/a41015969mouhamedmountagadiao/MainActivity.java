package com.exam.a41015969mouhamedmountagadiao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final Button btnCreate = findViewById(R.id.btnCreate);
    btnCreate.setOnClickListener(v -> {
      final Intent intent = new Intent(this, CreateActivity.class);
      startActivity(intent);
    });

    final Button btnAfficherLivre = findViewById(R.id.btnShowBooks);
    btnAfficherLivre.setOnClickListener(v -> {
      final Intent intent = new Intent(this, ShowBookActivity.class);
      startActivity(intent);
    });
  }

}