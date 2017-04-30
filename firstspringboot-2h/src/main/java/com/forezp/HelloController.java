package com.forezp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author XingJun Qi
 * @MyBlog www.qixingjun.tech
 * @Version 1.0.0
 * @Date 2017/2/17
 * @Description
 */
@RestController     //等同于同时加上了@Controller和@ResponseBody
public class HelloController {

//    //导入配置文件中的cupSize
//    @Value("${cupSize}")
//    private String cupSize;
//
//    @Value("${age}")
//    private Integer age;
//
//    @Value("${content}")
//    private String content;

    @Autowired
    private GirlProperties girlProperties;

    //访问/hello或者/hi任何一个地址，都会返回一样的结果
    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
    //等价于@GetMaping(value="/hello")
    //如果是POST请求，则等价于@PostMapping
    public String say(){
//        return cupSize+age+content;
        return girlProperties.getCupSize();
    }
}
