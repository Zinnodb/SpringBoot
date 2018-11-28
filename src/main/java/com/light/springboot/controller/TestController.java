package com.light.springboot.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController//相当于Controller 和 ResponseBody
@EnableAutoConfiguration//根据你导入的jar包,来分析你对spring的配置
public class TestController {
	
	@GetMapping("/helloworld")//实际上是组合注解,是@RequestMapping(method = RequestMethod.GET)的缩写
	public String helloworld() {
		return "helloworld";
	}
	
	@GetMapping("/helloworld2")
	public String helloworld2() {
		return "helloworld2";
	}
	@RequestMapping(value="/helloworld3/{id}",method=RequestMethod.GET)
	public String helloworld3(@PathVariable("id") Integer id) {
		return "helloworld3-id:"+id;
	}
	
	@RequestMapping(value="/helloworld4",method=RequestMethod.GET)
	public String helloworld4(@RequestParam(value="name",required=false,defaultValue="二狗") String name) {
		return "helloworld4-name:"+name;
	}
}
