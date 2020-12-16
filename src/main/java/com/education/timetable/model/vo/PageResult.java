package com.education.timetable.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

@Data
@NoArgsConstructor
public class PageResult<T> {

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
