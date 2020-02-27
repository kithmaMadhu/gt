import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Alu {

    Map<String, Instruction> cnt;

    public Alu() {

        cnt = new HashMap<String, Instruction>();

        class ADD implements Instruction {
            public void execute(String [] cmmnd, CPUReg regFile)
                    throws IOException  {
                regFile.writeReg(cmmnd[1],
                        regFile.readReg(cmmnd[2]) +
                                regFile.readReg(cmmnd[3]));
            }
        }
        cnt.put("100000", new ADD());

        class SUB implements Instruction {
            public void execute(String [] cmmnd, CPUReg regFile)
                    throws IOException  {
                regFile.writeReg(cmmnd[1],
                        regFile.readReg(cmmnd[2]) -
                                regFile.readReg(cmmnd[3]));
            }
        }
        cnt.put("100010", new SUB());

        class MUL implements Instruction {
            public void execute(String [] cmmnd, CPUReg regFile)
                    throws IOException  {
                regFile.writeReg(cmmnd[1],
                        regFile.readReg(cmmnd[2]) *
                                regFile.readReg(cmmnd[3]));
            }
        }
        cnt.put("011000", new MUL());

        class DIV implements Instruction {
            public void execute(String [] cmmnd, CPUReg regFile)
                    throws IOException  {
                regFile.writeReg(cmmnd[1],
                        regFile.readReg(cmmnd[2]) /
                                regFile.readReg(cmmnd[3]));
            }
        }
        cnt.put("011010", new DIV());

        class lw implements Instruction {
            public void execute(String [] cmmnd, CPUReg regFile)
                    throws IOException  {
                regFile.writeReg(cmmnd[1], regFile.readReg(cmmnd[3]));
            }
        }
        cnt.put("100011", new lw());

        /*class lw implements Instruction {
            public void execute(String [] cmmnd, CPUReg regFile)
                    throws IOException  {
                regFile.writeReg(cmmnd[1], regFile.readReg(cmmnd[2]));
            }
        }
        cnt.put("101011", new lw());*/

        class sw implements Instruction {
            public void execute(String [] cmmnd, CPUReg regFile)
                    throws IOException  {
                regFile.writeReg(cmmnd[2], regFile.readReg(cmmnd[1]));
            }
        }
        cnt.put("101011", new sw());


    }


    public void executeInstruction(String [] cmmnd, CPUReg regFile)
            throws IOException {

        Instruction inst = cnt.get(cmmnd[0]);
        if(inst == null) throw new
                IOException("Cannot find instruction");

        inst.execute(cmmnd, regFile);
    }
}





