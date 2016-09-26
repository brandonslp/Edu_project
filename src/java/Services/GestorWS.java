/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.LocaleDAO;
import com.google.gson.Gson;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pojos.Departamento;
import pojos.Municipio;

/**
 *
 * @author brand
 */
@WebService(serviceName = "GestorWS")
public class GestorWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllDepartments")
    public String getAllDepartments() {
        //TODO write your implementation code here:
        LocaleDAO ldao = new LocaleDAO();
        List<Departamento> listD = ldao.getAllDeparment();
        String str= new Gson().toJson(listD);
        /*String str="";
        for (Departamento departamento : listD) {
            str+=departamento.getDepNombre()+"\n";
        }*/
        return str;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getMunipsById")
    public String getMunipsById(@WebParam(name = "idDept") int idDept) {
        LocaleDAO ldao = new LocaleDAO();
        List<Municipio> listM = ldao.getMunipsById(idDept);
        //String str = new Gson().toJson(listM);
        String str = "";
        for (Municipio municipio : listM) {
            str += municipio.getMunNombre()+". ";
        }
        return str;
    }
}
