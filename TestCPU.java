import java.io.IOException;

class TestCPU {

	static String instruct[] = {
			//"10001100001000000000000000001010",
			//"10001100010000000000000000010100",
			//"00000000001000100001100000100000",
			"00000000011000100001100000011000"};
	static char[] a = instruct[0].toCharArray();

	static char[] opc = {a[0],a[1],a[2],a[3],a[4],a[5]};
	static String opc1 = String.valueOf(opc);//Arrays.toString(opcode);
	static String function;
	//static int regrd,immediate;

	public static String checkFunc(){
		if (opc1== "000000"){
			char[] func = {a[26],a[27],a[28],a[29],a[30],a[31]};
			function = String.valueOf(func);
			//function = Integer.parseInt(fun1);
			return function;
		}
		else{return opc1;}
	}

	char[] rd1 = {a[16],a[17],a[18],a[19],a[20]};
	static int regrd = 16*Integer.parseInt(String.valueOf(a[16]))+8*Integer.parseInt(String.valueOf(a[17]))+4*Integer.parseInt(String.valueOf(a[18]))+2*Integer.parseInt(String.valueOf(a[19]))+1*Integer.parseInt(String.valueOf(a[20]));
	String rd2 = String.valueOf(rd1);
	int rd = Integer.parseInt(rd2);

	static char[] imm = {a[16],a[17],a[18],a[19],a[20],a[21],a[22],a[23],a[24],a[25],a[26],a[27],a[28],a[29],a[30],a[31]};
	//int regrs = 16*Integer.parseInt(String.valueOf(a[6]))+8*Integer.parseInt(String.valueOf(a[7]))+4*Integer.parseInt(String.valueOf(a[8]))+2*Integer.parseInt(String.valueOf(a[9]))+1*Integer.parseInt(String.valueOf(a[10]));
	 static String imm1 = String.valueOf(imm);
	 static int immediate = Integer.parseInt(imm1);

	char[] rs1 = {a[6],a[7],a[8],a[9],a[10]};
	static int regrs = 16*Integer.parseInt(String.valueOf(a[6]))+8*Integer.parseInt(String.valueOf(a[7]))+4*Integer.parseInt(String.valueOf(a[8]))+2*Integer.parseInt(String.valueOf(a[9]))+1*Integer.parseInt(String.valueOf(a[10]));
	String rs2 = String.valueOf(rs1);
	int rs = Integer.parseInt(rs2);

	char[] rt1 = {a[11],a[12],a[13],a[14],a[15]};
	static int regrt = 16*Integer.parseInt(String.valueOf(a[11]))+8*Integer.parseInt(String.valueOf(a[12]))+4*Integer.parseInt(String.valueOf(a[13]))+2*Integer.parseInt(String.valueOf(a[14]))+1*Integer.parseInt(String.valueOf(a[15]));
	String rt2 = String.valueOf(rt1);
	int rt = Integer.parseInt(rt2);



	public static void main(String [] args)  {
		try {

			CPUReg regFile = new CPUReg();
			Alu cnt = new Alu();

			//checkDest();

			if (opc1=="000000"){
				String [] cmd = {checkFunc(),regFile.regNames[regrd],regFile.regNames[regrs],regFile.regNames[regrt]};
				cnt.executeInstruction(cmd, regFile);
			}
			else{
				String [] cmd = {checkFunc(),regFile.regNames[regrt],regFile.regNames[regrs],String.valueOf(immediate)};
				cnt.executeInstruction(cmd, regFile);
			}

		} catch(IOException e) {
			System.out.println(e);
		}
	}

}

		      
