//package com.education.timetable.model.dto;
//
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//
//import java.io.Serializable;
//
//public class OffsetPageRequest implements Pageable, Serializable {
//
//  private static final long serialVersionUID = -25822477129613575L;
//
//  private int limit;
//  private int offset;
//  private final Sort sort;
//
//  public OffsetPageRequest(int offset, int limit, Sort sort) {
//    if (offset < 0) {
//      throw new IllegalArgumentException("Offset index must not be less than 0");
//    }
//
//    if (limit < 1) {
//      throw new IllegalArgumentException("Limit must not be less than 1");
//    }
//    this.limit = limit;
//    this.offset = offset;
//    this.sort = sort;
//  }
//
//  public OffsetPageRequest(int offset, int limit, Sort.Direction direction, String... properties) {
//    this(offset, limit, Sort.(direction, properties));
//  }
//
//  @Override
//  public int getPageNumber() {
//    return offset / limit;
//  }
//
//  @Override
//  public int getPageSize() {
//    return limit;
//  }
//
//  @Override
//  public long getOffset() {
//    return offset;
//  }
//
//  @Override
//  public Sort getSort() {
//    return sort;
//  }
//
//  @Override
//  public Pageable next() {
//    return new OffsetPageRequest((int) (getOffset() + getPageSize()), getPageSize(), getSort());
//  }
//
//  public OffsetPageRequest previous() {
//    return hasPrevious()
//        ? new OffsetPageRequest((int) (getOffset() - getPageSize()), getPageSize(), getSort())
//        : this;
//  }
//
//  @Override
//  public Pageable previousOrFirst() {
//    return hasPrevious() ? previous() : first();
//  }
//
//  @Override
//  public Pageable first() {
//    return new OffsetPageRequest(0, getPageSize(), getSort());
//  }
//
//  @Override
//  public boolean hasPrevious() {
//    return offset > limit;
//  }
//}
