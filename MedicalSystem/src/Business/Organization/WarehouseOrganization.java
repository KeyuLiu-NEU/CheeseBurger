/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.WarehouseRole;
import java.util.ArrayList;

/**
 *
 * @author siyuanzhang
 */
public class WarehouseOrganization extends Organization{
    private int medicineANum = 5;
    private int medicineBNum = 5;
    private int medicineCNum = 5;

    
    public WarehouseOrganization(){
        super(Organization.Type.Warehouse.getValue());
        
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new WarehouseRole());
        return roles;
    }

    public int getMedicineANum() {
        return medicineANum;
    }

    public void setMedicineANum(int medicineANum) {
        this.medicineANum = medicineANum;
    }

    public int getMedicineBNum() {
        return medicineBNum;
    }

    public void setMedicineBNum(int medicineBNum) {
        this.medicineBNum = medicineBNum;
    }

    public int getMedicineCNum() {
        return medicineCNum;
    }

    public void setMedicineCNum(int medicineCNum) {
        this.medicineCNum = medicineCNum;
    }
    
    public void medicineAPlusOne(){
        this.medicineANum++;
    }
    
    public void medicineBPlusOne(){
        this.medicineBNum++;
    }
    
    public void medicineCPlusOne(){
        this.medicineCNum++;
    }

}
