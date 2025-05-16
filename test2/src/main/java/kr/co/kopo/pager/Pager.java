package kr.co.kopo.pager;

public class Pager {

	private int page = 1;
	private int perPage = 10;
	
	//페이지 이동 구현
	//전체 개수 나누기 페이지그룹을 하면 마지막 페이지를 추출 가능함.
	private float total;	//나누고 나서의 나머지도 필요하기 때문에 float을 씀.
	private int perGroup = 3;
	
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	//필드는 선언되지 않았지만 넘겨줄 getter 작성
	public int getLast(){
		//나눠진 값을 올림해주고 int로 casting해줌.
		return (int)Math.ceil(total / perPage);
	}
}
