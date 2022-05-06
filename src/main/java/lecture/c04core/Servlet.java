package lecture.c04core;

public class Servlet {
	private Dao dao; // 다오없이는 안돼
	
	public void doGet() {
		dao.select();
	}
}
