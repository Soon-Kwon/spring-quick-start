package org.zerock.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum;
	private int amount;
	private int skip; // 스킵할 게시물 수 (pageNum - 1) * amount
	
	// 검색 처리를 위한 필드
	private String type;
	private String keyword;
	
	public Criteria() {
		this(1,10);
		this.skip = 0;
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		
		if(pageNum < 0) this.skip = 0; // 댓글 showList(-1)을 처리하기 위해서
		else this.skip = (pageNum - 1) * amount;
		
	}
	
	// setPageNum, setAmount를 호출되면 skip 값도 변경되어야 한다.
	public void setPageNum(int pageNum) {
		this.skip = (pageNum-1) * this.amount;
		this.pageNum = pageNum;
	}
	
	public void setAmount(int amount) {
		this.skip = (this.pageNum-1) * amount;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
		return type == null? new String[] {} : type.split("");
	}
	
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.amount)
				.queryParam("type", this.getType())
				.queryParam("keyword", this.getKeyword());
		
		return builder.toUriString();
				
	}
}
