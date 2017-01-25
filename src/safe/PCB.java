package safe;

import java.util.*;

/**
 * 进程控制块
 * @author hc
 *
 */
public class PCB {
	String name;
	//请求的资源数目
	int [] request=new int[3];
	//尚需的资源数目
	int [] need=new int[3];
	//已分配的资源数目
	int [] alloction=new int[3];
	
}
