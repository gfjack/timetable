package com.education.timetable.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

public class page {
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	public static class PagingResult {
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

	@Data
	@NoArgsConstructor
	public static class PagerResult<T> {

		/**
		 * 总记录
		 */
		private Integer total;

		/**
		 * 当前页中存放的记录,类型一般为List
		 */
		private Collection<T> items;

		public PagerResult(Object obj) {
			if (obj instanceof Collection) {
				this.items = reformMapValue((Collection) obj);
			} else if (obj instanceof PagingResult) {
				this.items = reformMapValue(((PagingResult) obj).getItems());
				this.total = ((PagingResult) obj).getTotal();
			}
		}

		public PageResult to() {
			PageResult pageResult = new PageResult();
			pageResult.setItems(this.getItems());
			pageResult.setCount(this.getTotal());
			return pageResult;
		}

		/**
		 * 针对map的结构做梳理
		 * {
		 * "id":123,
		 * "user.name":"aaa"
		 * }
		 * 转为
		 * {
		 * "id":123,
		 * "user":{
		 * "name":"aaa"
		 * }
		 * }
		 *
		 * @param collection
		 */
		private Collection reformMapValue(Collection collection) {
			if (CollectionUtils.isEmpty(collection)) {
				return collection;
			}

			//获取需要处理的key列表
			List<String> reformKeyList = new ArrayList<>();
			for (Object obj : collection) {
				Class cls = obj.getClass();
				if (Map.class.isAssignableFrom(cls)) {
					Map map = (Map) obj;
					for (Map.Entry entry : (Set<Map.Entry>) map.entrySet()) {
						if (entry.getKey().toString().indexOf(".") >= 0) {
							reformKeyList.add(entry.getKey().toString());
						}
					}
				}
				break;
			}

			//对map数据结构做整理
			if (reformKeyList.size() > 0) {
				for (Object obj : collection) {
					Map map = (Map) obj;
					for (String reformKey : reformKeyList) {
						Object value = map.remove(reformKey);
						String[] subKeys = reformKey.split("\\.");
						Map lastMap = map;
						for (int i = 0; i < subKeys.length; i++) {
							String subKey = subKeys[i];
							if (i == subKeys.length - 1) {
								lastMap.put(subKey, value);
							} else {
								if (lastMap.get(subKey) == null) {
									lastMap.put(subKey, new HashMap<>());
								}
								lastMap = (Map) lastMap.get(subKey);
							}
						}
					}
				}
			}
			return collection;
		}
	}

	@Data
	@NoArgsConstructor
	public static class PageResult<T> {

		/**
		 * 总记录
		 */
		private Integer count;

		/**
		 * 当前页中存放的记录,类型一般为List
		 */
		private Collection<T> items;

		public PageResult(Object obj) {
			if (obj instanceof Collection) {
				this.items = reformMapValue((Collection) obj);
			} else if (obj instanceof PagingResult) {
				this.items = reformMapValue(((PagingResult) obj).getItems());
				this.count = ((PagingResult) obj).getTotal();
			}
		}

		public PagerResult to() {
			PagerResult pagerResult = new PagerResult();
			pagerResult.setTotal(this.getCount());
			pagerResult.setItems(this.getItems());
			return pagerResult;
		}

		/**
		 * 针对map的结构做梳理
		 * {
		 * "id":123,
		 * "user.name":"aaa"
		 * }
		 * 转为
		 * {
		 * "id":123,
		 * "user":{
		 * "name":"aaa"
		 * }
		 * }
		 *
		 * @param collection
		 */
		private Collection reformMapValue(Collection collection) {
			if (CollectionUtils.isEmpty(collection)) {
				return collection;
			}

			//获取需要处理的key列表
			List<String> reformKeyList = new ArrayList<>();
			for (Object obj : collection) {
				Class cls = obj.getClass();
				if (Map.class.isAssignableFrom(cls)) {
					Map map = (Map) obj;
					for (Map.Entry entry : (Set<Map.Entry>) map.entrySet()) {
						if (entry.getKey().toString().indexOf(".") >= 0) {
							reformKeyList.add(entry.getKey().toString());
						}
					}
				}
				break;
			}

			//对map数据结构做整理
			if (reformKeyList.size() > 0) {
				for (Object obj : collection) {
					Map map = (Map) obj;
					for (String reformKey : reformKeyList) {
						Object value = map.remove(reformKey);
						String[] subKeys = reformKey.split("\\.");
						Map lastMap = map;
						for (int i = 0; i < subKeys.length; i++) {
							String subKey = subKeys[i];
							if (i == subKeys.length - 1) {
								lastMap.put(subKey, value);
							} else {
								if (lastMap.get(subKey) == null) {
									lastMap.put(subKey, new HashMap<>());
								}
								lastMap = (Map) lastMap.get(subKey);
							}
						}
					}
				}
			}
			return collection;
		}
	}
}
