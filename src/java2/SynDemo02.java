package java2;
/**
 * �������ģʽ
 * ����ʽ
 * 1.������˽�л�����ֹ�ⲿֱ�Ӵ�������
 * 2.����һ��˽�еľ�̬����
 * 3.����һ������Ĺ�����̬�������ʸñ���,����ñ���û�ж��󣬴����ö���
 * @author hc
 *
 */
public class SynDemo02 {	
	public static void main(String args[]){
		//������˽�л��ˣ��ⲿ����ֱ�Ӵ�������
		//Jvm j=new Jvm();
		Jvm jvm=Jvm.getJvm3();
		System.out.println(jvm.n);
	}
}
class Jvm{
	private static Jvm jvm=null;
	int n=10;
	private Jvm(){
		
	}
	public static Jvm getJvm3(){
		//��һ���жϣ�������ڶ���ֱ�ӷ��أ������Ч��
		/*
		 * �����˫����(Double Checking)
		 */
		if(null==jvm){
			synchronized(Jvm.class){
				if(null==jvm){
					try{
						Thread.sleep(1000);
					}catch(Exception e){
						e.printStackTrace();
					}
					jvm=new Jvm();
				}
			}
		}
		return jvm;
	}
	public static synchronized Jvm getJvm1(){
		if(null==jvm){
			try{
				//�Ŵ�������ĸ���
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			jvm=new Jvm();
		}
		return jvm;
	}
	public static Jvm getJvm2(){
		//Ч�ʲ��ߣ����ּ�ʹ���ڶ���Ҳ��Ҫ��,
		synchronized(Jvm.class){
			if(null==jvm){
				try{
					Thread.sleep(1000);
				}catch(Exception e){
					e.printStackTrace();
				}
				jvm=new Jvm();
			}
		}
		return jvm;
	}

}
