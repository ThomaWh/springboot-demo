package com.example.unified.controller;

import com.example.unified.entity.ResponseCodeEnum;
import com.example.unified.exception.GlobalException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(description = "测试接口")
@RequestMapping("/testController")
public class TestController {

    @PostMapping("/test")
    @ApiOperation(value = "测试统一返回体")
    public String test(){
        return "麻瓜";
    }

    @PostMapping("/aa")
    @ApiOperation(value = "测试统一返回体")
    public String aa(){
        List<String> list = new ArrayList<>();
       /* if(1 == 1){
            throw new GlobalException(ResponseCodeEnum.RETURN_CODE_100500 , "系统异常");
        }*/

        return list.get(2);
    }
}
