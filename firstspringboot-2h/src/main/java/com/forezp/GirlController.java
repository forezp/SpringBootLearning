package com.forezp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class GirlController {

    @Autowired
    private GirlRep girlRep;

    /**
     * 查询所有女生列表
     * @return
     */
    @RequestMapping(value = "/girls",method = RequestMethod.GET)
    public List<Girl> getGirlList(){
        return girlRep.findAll();
    }

    /**
     * 添加一个女生
     * @param cupSize
     * @param age
     * @return
     */
    @RequestMapping(value = "/girls",method = RequestMethod.POST)
    public Girl addGirl(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRep.save(girl);
    }

    /**
     * 根据Id查询女生
     * @param id
     * @return
     */
    @RequestMapping(value = "/girls/{id}",method = RequestMethod.POST)
    public Girl getGirl(@PathVariable("id") Integer id){
        return girlRep.findOne(id);
    }

    /**
     * 更新女生信息
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @RequestMapping(value = "/girls/{id}",method = RequestMethod.PUT)
    public Girl updateGirl(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRep.save(girl);
    }

    /**
     * 删除ID
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void updateGirl(@PathVariable("id") Integer id){
        girlRep.delete(id);
    }

    @RequestMapping(value = "girls/age/{age}",method = RequestMethod.GET)
    public List<Girl> getGirls(@PathVariable("age") Integer age){
        return girlRep.findByAge(age);
    }
}
