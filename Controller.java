import java.io.IOException;
import  java.util.ArrayList;

public class Controller {

    public static String inst;
    public static int x = -1;               // Program Counter
    public String opc1,rs2,rt2,rd2,imm1,function;
    public int regrs,regrt,regrd,immediate;

    public Controller()
    {
          //  while(InsMem.instructMemory!=null){
           // x = x + 1;
            //InstructDecode(InsMem.instructMemory);//}
    }

    public void InstructDecode(String array)
    {

        inst = array;//.get(x);            // Getting the instruction from the arraylist
        char [] a = inst.toCharArray();  // Creating a character array from that

         char[] opc = {a[0],a[1],a[2],a[3],a[4],a[5]};
         opc1 = String.valueOf(opc);//Arrays.toString(opcode);

        char[] rs1 = {a[6],a[7],a[8],a[9],a[10]};
        regrs = 16*Integer.parseInt(String.valueOf(a[6]))+8*Integer.parseInt(String.valueOf(a[7]))+4*Integer.parseInt(String.valueOf(a[8]))+2*Integer.parseInt(String.valueOf(a[9]))+1*Integer.parseInt(String.valueOf(a[10]));
        rs2 = String.valueOf(rs1);
        int rs = Integer.parseInt(rs2);

        char[] rt1 = {a[11],a[12],a[13],a[14],a[15]};
        regrt = 16*Integer.parseInt(String.valueOf(a[11]))+8*Integer.parseInt(String.valueOf(a[12]))+4*Integer.parseInt(String.valueOf(a[13]))+2*Integer.parseInt(String.valueOf(a[14]))+1*Integer.parseInt(String.valueOf(a[15]));
        rt2 = String.valueOf(rt1);
        int rt = Integer.parseInt(rt2);

        char[] rd1 = {a[16],a[17],a[18],a[19],a[20]};
        regrd = 16*Integer.parseInt(String.valueOf(a[16]))+8*Integer.parseInt(String.valueOf(a[17]))+4*Integer.parseInt(String.valueOf(a[18]))+2*Integer.parseInt(String.valueOf(a[19]))+1*Integer.parseInt(String.valueOf(a[20]));
        rd2 = String.valueOf(rd1);
        int rd = Integer.parseInt(rd2);

        char[] imm = {a[16],a[17],a[18],a[19],a[20],a[21],a[22],a[23],a[24],a[25],a[26],a[27],a[28],a[29],a[30],a[31]};
        //int regrs = 16*Integer.parseInt(String.valueOf(a[6]))+8*Integer.parseInt(String.valueOf(a[7]))+4*Integer.parseInt(String.valueOf(a[8]))+2*Integer.parseInt(String.valueOf(a[9]))+1*Integer.parseInt(String.valueOf(a[10]));
        imm1 = String.valueOf(imm);
        immediate = Integer.parseInt(imm1);

        char[] func = {a[26],a[27],a[28],a[29],a[30],a[31]};
         function = String.valueOf(func);



    }



}
