
import com.contabilidad.dao.AsientoDAO;
import com.contabilidad.models.Asientos;
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
        AsientoDAO asientoDAO = new AsientoDAO();
        List<Asientos> asientos = asientoDAO.getAsientosContables();
        for(int i = 0; i< asientos.size(); i++){
            System.out.println(asientos.get(i).getNumero());
        }
    }
    
}
