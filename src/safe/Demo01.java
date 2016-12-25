package safe;
import java.util.*;
public class Demo01 {
	//可用资源数目  A B C
	int [] available=new int[]{3,3,2};
	PCB p0=new PCB();
	PCB p1=new PCB();
	PCB p2=new PCB();
	PCB p3=new PCB();
	PCB p4=new PCB();
	PCB [] p=new PCB[5];
	
	public void init(){
		p[0]=p0;p[1]=p1;p[2]=p2;p[3]=p3;p[4]=p4;
		
		p0.alloction[0]=0;p0.alloction[1]=1;p0.alloction[2]=0;
		p0.need[0]=7;p0.need[1]=4;p0.need[2]=3;
		
		
		p1.alloction[0]=2;p1.alloction[1]=0;p1.alloction[2]=0;
		p1.need[0]=1;p1.need[1]=2;p1.need[2]=2;
		
		
		p2.alloction[0]=3;p2.alloction[1]=0;p2.alloction[2]=2;
		p2.need[0]=6;p2.need[1]=0;p2.need[2]=0;
		
		
		p3.alloction[0]=2;p3.alloction[1]=1;p3.alloction[2]=1;
		p3.need[0]=0;p3.need[1]=1;p3.need[2]=1;
		
		
		p4.alloction[0]=0;p4.alloction[1]=0;p4.alloction[2]=2;
		p4.need[0]=4;p4.need[1]=3;p4.need[2]=1;
		
		p0.request[0]=2;p0.request[1]=3;p0.request[2]=0;
	}
	
	public void first(){
		init();
		if(p0.request[0]<p0.need[0]&&p0.request[1]<p0.need[1]&&p0.request[2]<p0.need[2]){
			second();
		}
		System.out.println("出错，所需资源数已超过宣布的最大值");
	}
	public void second(){
		
	}
	
	public static void main(String args[]){
		
	}
}
