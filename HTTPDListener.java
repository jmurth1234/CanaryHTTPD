/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rymate
 */
class HTTPDListener extends PluginListener {

     public boolean onCommand(Player player, String[] split, NanoHTTPD httpd) {
        if (split[0].equalsIgnoreCase("/httpdstop") && player.canUseCommand("/httpd")) {
        httpd.stop();
        }
        if (split[0].equalsIgnoreCase("/httpdstart") && player.canUseCommand("/httpd")) {
        NanoHTTPD.main(CanaryHTTPD.httpdPort);
        }
        return true;


    }
}
