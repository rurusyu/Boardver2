package org.zerock.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageMaker;
import org.zerock.domain.StoreVO;
import org.zerock.service.StoreService;

@Controller
@RequestMapping("/store/*")
public class StoreController {

	private static final Logger logger = Logger.getLogger(StoreController.class);
	
	
	@Autowired
	StoreService service;
	
	@GetMapping("/list")//나한테 들어왔는데, 나중에 그 정보를 반환처리할때는 @ModelAttribute붙임. 나중에 써먹을꺼야.
	public void list(@ModelAttribute("cri") Criteria cri, Model model)throws Exception{
		
		logger.info(cri);
		//view에서 두개 데이터 같이 전달함. cri, list; jsp에서 연결해주면됨.
		List<StoreVO> list = service.getList(cri);
		
		logger.info(list);
		
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", new PageMaker(cri, service.getCount(cri)));
	}
}
