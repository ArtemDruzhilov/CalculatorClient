package com.test.calc;

import picocli.CommandLine;

/**
 * CLI application for calculating arithmetic expressions (client side)
 */
@CommandLine.Command(name = "calc")
public class Application implements Runnable{

    @CommandLine.Option(names = { "--host" }, paramLabel = "HOST", description = "hostname or ip address")
    private static String host = "localhost";

    @CommandLine.Option(names = { "--port" }, paramLabel = "PORT", description = "port")
    private static int port = 4567;

    @CommandLine.Option(names = { "-h", "--help" }, usageHelp = true, description = "display a help message")
    private boolean helpRequested = false;

    /**
     * Reading command line arguments (parsed automatically)
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        var exitCode = new CommandLine(new Application()).execute(args);
        System.exit(exitCode);
    }

    /**
     * Running client
     */
    @Override
    public void run() {
        new TelnetClient().connect(host, port);
    }
}
