package IODemo;
/*
 * ������
 * DataInputStream��DataOutputStream
 * ���ڴ���������Ҫ���ڽڵ���֮��
 */
import java.io.*;
public class TestDataStream {
	public static void main(String args[]){
		//�ֽ�����
		ByteArrayOutputStream baos= new ByteArrayOutputStream();
		DataOutputStream ds=new DataOutputStream(baos);
		try{
			//д���ֽ�����
			ds.writeDouble(Math.random());
			ds.writeBoolean(true);
			ByteArrayInputStream bais= new ByteArrayInputStream(baos.toByteArray());
			
			//���bais�е��ֽ���
			System.out.println(bais.available());
			
			DataInputStream dis= new DataInputStream(bais);
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
			
			
			ds.close();
			dis.close();
		}catch(IOException e){
			
		}
	}
}
