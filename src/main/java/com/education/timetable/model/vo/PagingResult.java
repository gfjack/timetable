package com.education.timetable.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Collection;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PagingResult {
  private int total;
  private Collection items;

  public PagingResult(int total) {
    this.total = total;
  }

  public PagingResult(int total, Collection items) {
    this.total = total;
    this.items = items;
  }

  public int getTotal() {
    return total;
  }

  public Collection getItems() {
    return items;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public void setItems(Collection items) {
    this.items = items;
  }
}
