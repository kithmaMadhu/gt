import java.io.IOException;
import java.util.ArrayList;

public class InsMem {

    public static ArrayList<String> instructMemory;

    public InsMem ()
    {
        InsMem.instructMemory.add("10001100000000010000000000001010");
        InsMem.instructMemory.add("10001100000000100000000000010100");
        InsMem.instructMemory.add("00000000001000100001100000100000");
        InsMem.instructMemory.add("00000000011000100001100000011000");

        // InsMem.instructMemory.add("00000000001000100000000000100000");
        //InsMem.instructMemory.add("00000000011001100010100000100010");
    }

    public static void main(String [] args)  {
        try {

            CPUReg regFile = new CPUReg();
            Controller cnt = new Controller();
            Alu cmmnd = new Alu();

            if (instructMemory != null){
                for (int i = 0; i < instructMemory.size(); i++) {
                    cnt.InstructDecode(instructMemory.get(i));

                    if (cnt.opc1 == "000000") {
                        String[] cmd = {cnt.function, regFile.regNames[cnt.regrd], regFile.regNames[cnt.regrs], regFile.regNames[cnt.regrt]};
                        cmmnd.executeInstruction(cmd, regFile);
                    } else {
                        String[] cmd = {cnt.opc1, regFile.regNames[cnt.regrt], regFile.regNames[cnt.regrs], String.valueOf(cnt.immediate)};
                        cmmnd.executeInstruction(cmd, regFile);
                    }
                }

        }System.out.println("R1 = " +
                    regFile.readReg("R1"));

        } catch(IOException e) {
            System.out.println(e);
        }
    }
}

