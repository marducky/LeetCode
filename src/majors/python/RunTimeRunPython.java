package majors.python;

import org.omg.SendingContext.RunTime;

public class RunTimeRunPython {
    public static void main(String[] args) throws Exception{
        Process process= Runtime.getRuntime().exec("python G:\\info\\NLPS_Code_Repos\\git\\LeetCode\\src\\majors\\python\\demo.py");
        process.waitFor();
    }
}
