
import com.contabilidad.dao.AsientoDAO;
import com.contabilidad.models.Asiento;
import com.cuentaxcobrar.dao.ClienteDAO;
import com.cuentaxcobrar.models.Cliente;
import java.util.ArrayList;
import java.util.List;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pideu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClienteDAO clientedao = new ClienteDAO();
        Cliente cliente = clientedao.getIdCliente(3);
        System.out.println(cliente.getNombres());
    }
    
}
