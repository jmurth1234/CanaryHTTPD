
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rymate
 */
public class CanaryHTTPD extends Plugin {

    private Logger log;
    public static String name = "CanaryHTTPD";
    public static String version = "v1";
    private HTTPDListener listener = new HTTPDListener();
    public static String[] httpdPort;
    private PropertiesFile properties = new PropertiesFile("CanaryHTTPD.properties");

    public void disable() {
        log = Logger.getLogger("Minecraft");
        log.info(name + " " + version + " disabled.");

    }

    public void enable() {
        log = Logger.getLogger("Minecraft");
        initialize();
        NanoHTTPD.main(httpdPort);
        log.info(name + " " + version + " enabled");
        etc.getInstance().addCommand("/httpdstop", "Stops the HTTPD server.");
        etc.getInstance().addCommand("/httpdstart", "If you have previously stopped the HTTPD server, this will start it :)");

    }

    /* Loads the properties and shit
     * Also creates the html folder
     */
    public void initialize() {
        new File("html" + File.separator).mkdirs();
        etc.getLoader().addListener(PluginLoader.Hook.COMMAND, this.listener,
        this, PluginListener.Priority.MEDIUM);

    }
}
