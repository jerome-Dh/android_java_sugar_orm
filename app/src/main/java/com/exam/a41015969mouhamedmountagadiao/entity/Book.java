package com.exam.a41015969mouhamedmountagadiao.entity;

import androidx.annotation.NonNull;

import com.orm.SugarRecord;

import java.util.Date;

public class Book extends SugarRecord<Book> {
  String title;
  String auteur;
  String genre;
  String datePub;
  String resume;

  public Book(){
  }

  public Book(String title, String auteur, String genre, String datePub, String resume){
    this.title = title;
    this.auteur = auteur;
    this.genre = genre;
    this.datePub = datePub;
    this.resume = resume;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuteur() {
    return auteur;
  }

  public void setAuteur(String auteur) {
    this.auteur = auteur;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getDatePub() {
    return datePub;
  }

  public void setDatePub(String datePub) {
    this.datePub = datePub;
  }

  public String getResume() {
    return resume;
  }

  public void setResume(String resume) {
    this.resume = resume;
  }

  @Override
  public String toString() {
    return "Book{" +
        "title='" + title + '\'' +
        ", auteur='" + auteur + '\'' +
        ", genre='" + genre + '\'' +
        ", datePub='" + datePub + '\'' +
        ", resume='" + resume + '\'' +
        ", id=" + id +
        '}';
  }
}