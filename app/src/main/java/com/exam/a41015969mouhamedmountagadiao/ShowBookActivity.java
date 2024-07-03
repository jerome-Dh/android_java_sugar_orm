package com.exam.a41015969mouhamedmountagadiao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.exam.a41015969mouhamedmountagadiao.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShowBookActivity extends AppCompatActivity {

  private ArrayAdapter<String> adapter;

  private List<String> items = new ArrayList<>();
  private List<Book> books = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_show_book);

    final Button btnAnnuler = findViewById(R.id.btnQuitter);
    btnAnnuler.setOnClickListener(v -> {
      final Intent intent = new Intent(this, MainActivity.class);
      startActivity(intent);
    });

    adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
    ListView listView = findViewById(android.R.id.list);
    listView.setAdapter(adapter);

    listView.setOnItemClickListener((adapterView, view, position, id) -> onListItemClick((ListView) adapterView, view, position, id));

    new Thread(() -> {
      books = Book.listAll(Book.class);

      runOnUiThread(() -> {
        Toast.makeText(getApplicationContext(), "Liste OK!", Toast.LENGTH_LONG).show();
        items = books.stream().map(item -> item.getId() + ": " + item.getTitle()).collect(Collectors.toList());
        adapter.addAll(items);
      });
    }).start();
  }

  protected void onListItemClick(ListView l, View v, int position, long id) {

    final Book selected = books.get(position);
    Toast.makeText(this, "Selected: " + selected.getTitle(), Toast.LENGTH_SHORT).show();

    final Intent intent = new Intent(this, BookDetailActivity.class);
    intent.putExtra("id", selected.getId());
    intent.putExtra("title", selected.getTitle());
    intent.putExtra("auteur", selected.getAuteur());
    intent.putExtra("genre", selected.getGenre());
    intent.putExtra("date", selected.getDatePub());
    intent.putExtra("resume", selected.getResume());
    startActivity(intent);
  }
}
