package com.exam.a41015969mouhamedmountagadiao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.exam.a41015969mouhamedmountagadiao.entity.Book;

import java.util.function.Consumer;

public class BookDetailActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_book_detail);

    final EditText title = findViewById(R.id.title),
        auteur = findViewById(R.id.auteur),
        genre = findViewById(R.id.genre),
        datePub = findViewById(R.id.datePub),
        resume = findViewById(R.id.resume);

    final Intent intent = getIntent();
    title.setText(intent.getStringExtra("title"));
    title.setEnabled(false);

    auteur.setText(intent.getStringExtra("auteur"));
    auteur.setEnabled(false);

    genre.setText(intent.getStringExtra("genre"));
    genre.setEnabled(false);

    datePub.setText(intent.getStringExtra("date"));
    datePub.setEnabled(false);

    resume.setText(intent.getStringExtra("resume"));
    resume.setEnabled(false);

    final Intent intentList = new Intent(this, ShowBookActivity.class);

    final Button btnAnnuler = findViewById(R.id.btnAnnuler2);
    btnAnnuler.setOnClickListener(v -> {
      startActivity(intentList);
    });

    long bookId = intent.getLongExtra("id", 0);
    final Button btnSupprimer = findViewById(R.id.btnSupprimer);
    btnSupprimer.setOnClickListener(v -> {

      ConfirmDeletionFragment confirm = new ConfirmDeletionFragment(
          ret -> {
            if (ret) {
              Book book = Book.findById(Book.class, bookId);
              if (book != null) {
                book.delete();
                Toast.makeText(this, "Deleted!", Toast.LENGTH_LONG).show();
                startActivity(intentList);
              }
              else {
                Toast.makeText(this, "An error occurred!", Toast.LENGTH_LONG).show();
              }
            }
          }
      );
      confirm.show(getSupportFragmentManager(), "confirm");
    });

    final Button btnModifier = findViewById(R.id.btnModifier);
    btnModifier.setOnClickListener(v -> {

      if (title.isEnabled()) {

        Book book = Book.findById(Book.class, bookId);
        if (book != null) {
          book.setTitle(title.getText().toString());
          book.setAuteur(auteur.getText().toString());
          book.setGenre(genre.getText().toString());
          book.setDatePub(datePub.getText().toString());
          book.setResume(resume.getText().toString());
          book.save();
        }

        btnModifier.setText("Modifier");
        btnSupprimer.setEnabled(true);
        Toast.makeText(this, "Données modifiées", Toast.LENGTH_LONG).show();

        title.setEnabled(false);
        auteur.setEnabled(false);
        genre.setEnabled(false);
        datePub.setEnabled(false);
        resume.setEnabled(false);
      } else {
        title.setEnabled(true);
        auteur.setEnabled(true);
        genre.setEnabled(true);
        datePub.setEnabled(true);
        resume.setEnabled(true);

        btnModifier.setText("OK");
        btnSupprimer.setEnabled(false);
      }
    });
  }
}