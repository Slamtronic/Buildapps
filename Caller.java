package pak;

import pac.Called1;
import pac.par.*;
public class Caller {

	public static void main(String[] args) {
		System.out.println("starting ........ \n");
		Called1 cal1=new Called1();
		Called2 cal2=new Called2();
		cal2.disp();
		System.out.println("this i from CALLED1:"+cal1.str1+" " +cal1.str2+" "+cal1.str3+" ");
		System.out.println("this i from CALLED2:"+cal2.stm1+" " +cal2.stm2+" "+cal2.stm3+" ");
		cal2.disp();
	}

}
