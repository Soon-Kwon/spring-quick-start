package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class pageDTO {

	final private int PAGE_PER_GROUP = 5; // 그룹당 보여줄 페이지 개수
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total;
	private Criteria cri;
	
	public pageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int) (Math.ceil(cri.getPageNum() / (double) PAGE_PER_GROUP)) * PAGE_PER_GROUP;
		this.startPage = this.endPage - (PAGE_PER_GROUP-1); 
		
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
