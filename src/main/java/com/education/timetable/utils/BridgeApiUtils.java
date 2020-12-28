package com.education.timetable.utils;

import com.education.timetable.model.vo.CourseVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//@FeignClient(url = "http://39.97.67.96:8080", value = "timetable")
public interface BridgeApiUtils {

    @ApiOperation("获取多个课程")
    @RequestMapping(value = "/v1/courses", method = RequestMethod.GET)
    List<CourseVo> getAll();

}
