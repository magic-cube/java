import java.util.HashMap;
import java.util.Map;
/**
 * �Զ���������
 * jdk1.5֮��
 * �ں��ʵ�ʱ���Զ���������
 * 	�Զ�����������ת���ɶ���
 * 	�Զ�������ת���ɻ�������
 * @author hc
 *
 */
public class MapAutoboxing {

	public static void main(String[] args) {
		Map m =new HashMap();
		//putҪ��Ž�ȥ���Ƕ���jdk1.5֮��֧�����Զ�������ƣ����������͵�1�Զ������Integer����
		m.put("a",1);
		//unboxing  �Զ����
		System.out.println(m.get("a"));
	}

}
