package org.zerock.domain;

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
	
	public Criteria() {
		this(1,10);
		this.skip = 0;
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.skip = (pageNum - 1) * amount;
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
}
