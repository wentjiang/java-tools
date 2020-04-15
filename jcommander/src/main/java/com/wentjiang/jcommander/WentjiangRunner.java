package com.wentjiang.jcommander;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class WentjiangRunner {

    @Parameter(names = {"-h", "--help"}, description = "Prints usage information", help = true)
    private boolean mHelp;

    @Parameter(names = {"-n", "--name"}, description = "the user's name", help = true)
    private String name = "default_name";

    public static void main(String[] args) {
        WentjiangRunner runner = new WentjiangRunner();
        JCommander jCommander = new JCommander(runner, args);
        jCommander.setProgramName("TestRunner");
        if (runner.mHelp) {
            jCommander.usage();
            return;
        }

        int ret = runner.run();
        System.exit(ret);
    }

    public int run() {
        System.out.println("run " + name + " runner!");
        return 0;
    }
}
