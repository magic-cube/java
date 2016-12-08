package SaveObject;
/**
 * ��������Ҿ���  finalize
 * Ҫ��������һ����������������Ҫ�������α�ǹ���
 * 1.���пɴ��Է�������û����GC Roots �����ӵ�������������һ�α�ǲ�����һ��ɸѡ�������Ƿ��б�Ҫִ��finalize����
 *   �������û���Լ�ȥ����finalize��������������Ѿ����ù�finalize������������������������Ϊ��û��Ҫִ�С�
 * 2.�����б�Ҫָ��finalize��������ô�������ᱻ������һ��F��Queue�Ķ����У�
 *   finalize�����Ƕ��������������˵����һ�λ��ᣬGC����F-Queue�����еĶ�����еڶ���С��ģ�ı��
 *   �������Ҫ��finalize�������Լ���ֻ���������������ϵ��κ�һ����������������
 *   Ʃ�磬���Լ���this�ؼ��֣���ֵ��ĳ������������ĳ�Ա��������ô�ڶ��α��ʱ�������Ƴ������������ա��ļ��ϣ�
 *   ���������ʱ��û�����ѣ��ǻ�����������ı�������
 *   
 * PS���κζ����finalize����ֻ�ᱻִ��һ��
 * @author hc
 *
 */
public class Finalize {
	public static Finalize SAVE_HOOK;
	protected void finalize() throws Throwable{
		super.finalize();
		System.out.println("finalize mehtod executed");
		Finalize.SAVE_HOOK=this;
	}
	public void isAlive(){
		System.out.println("yes,i am alive :)");
	}
	public static void main(String args[]) throws InterruptedException{
		SAVE_HOOK=new Finalize();
		
		//����ľ���֮·������
		SAVE_HOOK=null; /*�Ͽ�����*/
		System.gc();
		
		//finalize�������ȼ��ܵͣ���ͣ0.5��ȴ���
		Thread.sleep(500);
		if(SAVE_HOOK!=null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("no,i am dead :(");
		}
		
		//����ĵڶ��ξ��꣡����
		SAVE_HOOK=null; /*�Ͽ�����*/
		System.gc();
		
		//finalize�������ȼ��ܵͣ���ͣ0.5��ȴ���
		Thread.sleep(500);
		if(SAVE_HOOK!=null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("no,i am dead :(");
		}
	}
}
