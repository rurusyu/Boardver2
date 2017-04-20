package org.zerock.domain;
//검색기능이라고 생각하면됨. 페이지 번호가 필요함.

public class Criteria {

	private int page;
	private int size;
	
	public Criteria(){
		this.page =2;
		this.size = 10;
		
	}
	
	
	public Criteria settingPage(int page){
		if(page <=0){
			page =1;
		}
		return this;
	}
	//빌드업패턴쓰면 정보를 쓰고 싶은대로 쓸수 있음. 안쓰면 생성자 4개만들어야함.
	public Criteria settingSize(int size){
		if(size <=0 || size <= 5){
			this.size = 5;	
		}
		return this;
	}
	
	public int getSkip(){
		
		return (this.page-1)*this.size;
	}
	
	public int getAmount(){
		
		return this.size;
	}


	public int getPage() {
		
		return page;
	}

	
	public void setPage(int page) {
		this.page = page;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public int getSize() {
		
		return this.size;
	}
	
}
