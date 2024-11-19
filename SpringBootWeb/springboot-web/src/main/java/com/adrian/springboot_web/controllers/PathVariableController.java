package com.adrian.springboot_web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.springboot_web.models.User;
import com.adrian.springboot_web.models.DTO.ParamDto;

@RestController
@RequestMapping("/api/var")
public class PathVariableController{

    @Value("${config.username}")
    private String username;

    @Value("${config.message}")
    private String message;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    @Value("${config.code}")
    private Integer code;


    @Value("#{'${config.listOfValues}'.split(',')}")
    private List<String> valueList;

    @Value("#{${config.valuesMap}}")
    private Map<String,Object> valuesMap;

    @Value("#{${config.valuesMap}.product}")
    private String product;



    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable() String message){
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }
    
    @GetMapping("/mix/{product}/{code}")
    public Map<String, Object> mixPathVar(@PathVariable String product,
    @PathVariable Long code){

        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("code",code);

        return json;
    }


    @PostMapping("/create")
    public User create(@RequestBody User user){

        user.setName(user.getName().toUpperCase());
        return user;
    }




    @GetMapping("/values")
    public Map<String, Object> values(){
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("message", message);
        json.put("code", code);
        json.put("listOfValues", listOfValues);
        json.put("valueList", valueList);
        json.put("valuesMap", valuesMap);
        json.put("product", product);


        return json;
    }


}
