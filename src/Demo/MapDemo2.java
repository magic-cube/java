package Demo;
/**
 * javaBean Ҳ��ʵ���࣬         po bo vo ��
 * ����setter��getter����������
 * @author hc
 *
 */
public class MapDemo2 {
	private String name;
	private int count;
	public MapDemo2() {
	
	}
	public MapDemo2(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
