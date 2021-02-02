package com.test.calc;

import picocli.CommandLine;

@CommandLine.Command(name = "calc")
public class Application implements Runnable{

    @CommandLine.Option(names = { "--host" }, paramLabel = "HOST", description = "hostname or ip address")
    private static String host = "localhost";

    @CommandLine.Option(names = { "--port" }, paramLabel = "PORT", description = "port")
    private static int port = 4567;

    @CommandLine.Option(names = { "-h", "--help" }, usageHelp = true, description = "display a help message")
    private boolean helpRequested = false;

    public static void main(final String[] args) {
        var exitCode = new CommandLine(new Application()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {
        new TelnetClient().connect(host, port);
    }
}
