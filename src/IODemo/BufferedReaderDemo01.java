package IODemo;
import java.io.*;
/**
 * ������
 * ������Ҫ�׽�����Ӧ�Ľڵ���֮�ϣ��Զ�д�������ṩ�˻���Ĺ��ܣ�����˶�д��Ч��
 * �������������ļ����˶�Ӳ�̵Ķ�д������������Ӳ��
 * 
 * BufferedReader��Reader in��
 * BufferedReader��Reader in, int size�� �Զ��建�����Ĵ�С
 * 
 * @author hc
 *
 */
public class BufferedReaderDemo01 {
	public static void main(String args[]){
		try{
			BufferedReader br = new BufferedReader(new FileReader("C:/my/test.txt"));
			String s=null;
			/*
			 * BufferedReader��һ���ܺ��õķ�������
			 * readLine(),�����ַ�����һ�ζ�ȡһ��
			 * ����ֻ��Ϊ�����������Ҫ�������������BufferedReaderҲ��ֵ�õ�
			 */
			while((s=br.readLine())!=null){
				System.out.print(s);
			}
			br.close();
		}catch(IOException e1){
			e1.printStackTrace();
		}
	}
}
