package com.education.timetable.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUtils {

  /**
   * 分割List
   *
   * @param list 待分割的list
   * @param pageSize 每段list的大小
   * @return List<<List<T>>
   */
  public static <T> List<List<T>> splitList(List<T> list, int pageSize) {

    int listSize = list.size();
    // list的大小
    int page = (listSize + (pageSize - 1)) / pageSize;
    // 页数

    List<List<T>> listArray = new ArrayList<List<T>>();
    // 创建list数组 ,用来保存分割后的list
    for (int i = 0; i < page; i++) {
      // 按照数组大小遍历
      List<T> subList = new ArrayList<T>();
      // 数组每一位放入一个分割后的list
      for (int j = 0; j < listSize; j++) {
        // 遍历待分割的list
        int pageIndex = ((j + 1) + (pageSize - 1)) / pageSize;
        // 当前记录的页码(第几页)
        if (pageIndex == (i + 1)) {
          // 当前记录的页码等于要放入的页码时
          subList.add(list.get(j));
          // 放入list中的元素到分割后的list(subList)
        }

        if ((j + 1) == ((j + 1) * pageSize)) {
          // 当放满一页时退出当前循环
          break;
        }
      }
      listArray.add(subList);
      // 将分割后的list放入对应的数组的位中
    }
    return listArray;
  }

  public static <T> List<T> subList(List<T> list, int offset, int limit) {
    if (list == null) {
      return null;
    }
    int size = list.size();
    int subListEnd = offset + limit;
    if (subListEnd > size) {
      subListEnd = size;
    }
    if (offset > subListEnd) {
      return new ArrayList<>();
    } else {
      return list.subList(offset, subListEnd);
    }
  }

  /**
   * paging list, index must begin from 1
   * @param sourceList 最开始的list
   * @param page 总页数
   * @param pageSize 每页大小
   * @param <T> 泛型
   * @return list of resources
   */
  public static <T> List<T> getPage(List<T> sourceList, int page, int pageSize) {
    int fromIndex = (page - 1) * pageSize;
    if(sourceList == null || sourceList.size() < fromIndex){
      return Collections.emptyList();
    }

    // toIndex exclusive
    return sourceList.subList(fromIndex, Math.min(fromIndex + pageSize, sourceList.size()));
  }

}
