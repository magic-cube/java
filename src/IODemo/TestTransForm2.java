package IODemo;
import java.io.*;
/**
 * ת����
 * ���ֽ���ת�����ַ���
 * OutputStreamWriter
 * true,��ԭ�л��������
 * @author hc
 */
public class TestTransForm2 {
	public static void main(String args[]){
		try{
			OutputStreamWriter ops= new OutputStreamWriter(new FileOutputStream("C:/my/hc.txt",true));
			String s;
//			BufferedReader brd = new BufferedReader(new FileReader("C:/my/liuke.txt"));
//			while((s=brd.readLine())!=null){
//				ops.write(s);
//				System.out.println();
//			}
			//����ֱ��дһ���ַ�����ȥ
			ops.write("abcdefj higklmn opq rst uvw xyzxyz now you see i can say my abc");
			//��������е�����д����Ŀ�ĵ�
			ops.flush();
			//Ҫ�ǵù�
//			brd.close();
			ops.close();
		}catch(IOException e){
			System.out.println("��è����");
		}
	}
}
