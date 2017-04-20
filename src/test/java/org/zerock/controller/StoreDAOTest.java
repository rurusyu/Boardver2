package org.zerock.controller;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.StoreVO;
import org.zerock.persistence.StoreDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class StoreDAOTest {

	private static Logger logger = Logger.getLogger(StoreDAOTest.class);
	
	
	@Inject
	StoreDAO dao;
	
	
	@Test
	public void testList(){
		
		dao.list(new Criteria().settingPage(2).settingSize(5))
		.forEach(store -> logger.info(store)); //어차피 리턴이 this니깐 이렇게 코딩
		
	}
	
	@Test
	public void testCreate(){
		
		StoreVO vo = new StoreVO();
		vo.setSname("강남불백");
		vo.setLat(37.492293);
		vo.setLng(127.033571);
		vo.setInfo("가까운집");
		dao.create(vo);
		
	}
	
	@Test
	public void test1(){
		logger.info(dao);
		logger.info(dao.getTime());
	}
}
