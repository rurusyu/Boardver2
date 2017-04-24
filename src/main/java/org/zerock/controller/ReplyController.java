package org.zerock.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.ReplyVO;

@RestController
@RequestMapping("/replies/*")
public class ReplyController {

	@PutMapping("/{bno}/{rno}")
	public String modify(@PathVariable("bno") Integer bno, 
			 @PathVariable("rno") Integer rno,
			 @RequestBody ReplyVO vo){
		
		System.out.println("bno : "+bno);
		System.out.println("rno : "+rno);
		System.out.println("vo : "+vo);
		
		return "success";
		
	} 
	
	
	
	@PostMapping("/{bno}/{rno}")
	public String update(@PathVariable("bno") Integer bno, 
			 @PathVariable("rno") Integer rno){
		
		System.out.println("bno : "+bno);
		System.out.println("rno : "+rno);
		
		return "success";
		
	} 
	
	
	//delete 방식쓸꺼임
	@DeleteMapping("/{bno}/{rno}")
	public String delete(@PathVariable("bno") Integer bno, 
						 @PathVariable("rno") Integer rno){
		
		System.out.println("bno : "+bno);
		System.out.println("rno : "+rno);
		
		return "success";
	}
	
	@PostMapping("/{bno}") //게시판번호
	public ReplyVO create(@PathVariable("bno") Integer bno, 
			    		  @RequestBody ReplyVO vo){
		System.out.println("bno : " +bno);
		System.out.println("vo : " + vo);
		return vo;
	}
	
}
