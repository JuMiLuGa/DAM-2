/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package odoo;

import java.net.MalformedURLException;
import java.net.URL;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

/**
 *
 * @author Lubián_Gañete_Julio_Miguel
 */
public class Odoo {

    static List<Map<String, Object>> odooTest() throws MalformedURLException, XmlRpcException {
        final String url = "http://192.168.250.2:8069",
                db = "Odoo",
                username = "lubian.ganete.juliomiguel.ald@gmail.com",
                password = "09dc60d2b97434e126ab6b0d153be4be4cad7f68";

        final XmlRpcClient client = new XmlRpcClient();

        final XmlRpcClientConfigImpl common_config = new XmlRpcClientConfigImpl();
        common_config.setServerURL(new URL(String.format("%s/xmlrpc/2/common", url)));
        client.execute(common_config, "version", emptyList());
        int uid = (int) client.execute(common_config, "authenticate", asList(db, username, password, emptyMap()));

        final XmlRpcClient models = new XmlRpcClient() {
            {
                setConfig(new XmlRpcClientConfigImpl() {
                    {
                        setServerURL(new URL(String.format("%s/xmlrpc/2/object", url)));
                    }
                });
            }
        };
        List ids = asList((Object[]) models.execute("execute_kw", asList(
                db, uid, password,
                "res.partner", "search",
                asList(asList(
                        asList("is_company", "=", true)))
        )));

        List partnerResults = asList((Object[]) models.execute("execute_kw", asList(
                db, uid, password,
                "res.partner", "read",
                asList(ids),
                new HashMap() {
            {
                put("fields", asList("name", "street", "city", "phone", "mobile"));
            }
        }
        )));

        return partnerResults;
    }
}
