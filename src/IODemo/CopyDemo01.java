package IODemo;
import java.io.*;
/**
 * ʹ��InputStream��OutputStreamʱ������8λ�ֽ���
 * һ�β���һ���ֽ�
 * ʹ��Reader��Writerʱ�������ַ���  16bit  ������UniCode
 * һ�β���һ���ַ��������ֽ�
 * ����ʹ��InputStreamʱ���ܳɹ���ȡһ�����֣�һ�����������ֽڣ�ÿ���ó�����ֶ�������
 * ���Reader��Writer�̳м̳нṹ����Ϊ��������i/o�����ж���֧��UniCode
 * @author hc
 *
 */
public class CopyDemo01 {
	public static void main(String args[]){
		int b=0;
		FileReader in = null;
		FileWriter out = null;
		try{
			in= new FileReader("C:/Users/hc/workspace/1/src/IODemo/TestFileInputStream.java");
			out = new FileWriter("C:/my/t1.java");
			/*
			 * ��Դ�ļ����ݴ�ӡ������̨
			 * in.read()==-1ʱ�ļ�����
			 * ͬʱ����д���������
			 */
			while((b=in.read())!=-1){
				System.out.print((char)b);
				out.write(b);
			}
			//�ر�����
			in.close();
			//�ر����
			out.close();
		}catch(FileNotFoundException e1){
			System.out.println("δ�ҵ�ָ���ļ�");
			System.exit(-1);
		}catch(IOException e){
			System.out.println("�ļ����Ƴ���");
			System.exit(-1);
		}
	}
}
