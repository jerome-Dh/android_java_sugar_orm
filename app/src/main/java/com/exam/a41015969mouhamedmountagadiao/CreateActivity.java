package com.exam.a41015969mouhamedmountagadiao;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.exam.a41015969mouhamedmountagadiao.entity.Book;

public class CreateActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create);

    final EditText title = findViewById(R.id.title),
      auteur = findViewById(R.id.auteur),
      genre = findViewById(R.id.genre),
      datePub = findViewById(R.id.datePub),
      resume = findViewById(R.id.resume);

    final Button btnAnnuler = findViewById(R.id.btnAnnuler);
    btnAnnuler.setOnClickListener(v -> {
      final Intent intent = new Intent(this, MainActivity.class);
      startActivity(intent);
    });

    final Button btnAjouter = findViewById(R.id.btnAjouter);
    btnAjouter.setOnClickListener(v -> {

      String titleValue = title.getText().toString(),
          auteurValue = auteur.getText().toString(),
          genreValue = genre.getText().toString(),
          datePubValue = datePub.getText().toString(),
          resumeValue = resume.getText().toString();

      if (titleValue.length() == 0) {
        Toast.makeText(getApplicationContext(), "Entrez le titre", Toast.LENGTH_LONG).show();
        return;
      }

      if (auteurValue.length() == 0) {
        Toast.makeText(getApplicationContext(), "Entrez l'auteur", Toast.LENGTH_LONG).show();
        return;
      }

      if (genreValue.length() == 0) {
        Toast.makeText(getApplicationContext(), "Entrez le genre", Toast.LENGTH_LONG).show();
        return;
      }

      if (datePubValue.length() == 0) {
        Toast.makeText(getApplicationContext(), "Entrez la date", Toast.LENGTH_LONG).show();
        return;
      }

      new Thread(() -> {
        Book book = new Book(titleValue, auteurValue, genreValue, datePubValue, resumeValue);
        book.save();

        runOnUiThread(() -> {
          title.setText("");
          auteur.setText("");
          genre.setText("");
          datePub.setText("");
          resume.setText("");
          title.requestFocus();
          Toast.makeText(getApplicationContext(), "Livre sauvegardé", Toast.LENGTH_LONG).show();
        });
      }).start();
    });
  }
}
