package org.zerock.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.MessageVO;

@RestController //모든 메소드의 @ResponseBody가 생략되있음.
@RequestMapping("/s2")
public class Sample2Controller {

	@GetMapping("/doA")
	public String doA(){
		return "hello";
	}
	//데이터 추가.  
	 
	@GetMapping("/doC/{cat}/{item}")
	public void doC(@PathVariable("cat") String cat,
			@PathVariable("item") String item){
		System.out.println("CAT: "+cat);
		System.out.println("ITEM: "+item);
	}
	
	//제이슨 수집연습
	@PostMapping("/msg") //데이터 수집을 json으로 하고 보낼꺼임. 포스트방식에  제이슨임. 화면개발할라면 오래걸림. 과거에는 폼테그로 주고 받았는데, 이제는 아님.
	public MessageVO doD(@RequestBody MessageVO vo){
		System.out.println(vo);
		return vo;
	}
	
	
	@GetMapping("/doB")
	public Map<String, String> doB(){
		
		Map<String, String> map = new HashMap<>();
		map.put("uid", "AAAA");
		map.put("upw", "BBBB");
		
		return map;
		
	}
	
}
