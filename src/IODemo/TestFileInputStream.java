package IODemo;
/**
 * java IO
 */
import java.io.*;

public class TestFileInputStream {

	public static void main(String[] args) {
		int b=0;
		FileInputStream in = null;
		try{
			in=new FileInputStream("C:/Users/hc/workspace/1/src/IODemo/TestFileInputStream.java");
		}catch(FileNotFoundException e){
			System.out.println("δ�ҵ�ָ���ļ�");
			System.exit(-1);
		}
		
		
		try{
			long num=0;
			while((b=in.read())!=-1){
				System.out.print((char)b);
				//��¼��ȡ���ֽ���
				num++;
			}
			System.out.println();
			System.out.println("����ȡ��"+num+"���ֽ�");
		}catch(IOException e){
			System.out.println("�ļ���ȡ����");
			System.exit(-1);
		}

	}

}
