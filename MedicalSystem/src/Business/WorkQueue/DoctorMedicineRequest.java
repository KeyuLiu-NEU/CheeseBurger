/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author raunak
 */
public class DoctorMedicineRequest extends WorkRequest{
    
    private String Result;
    
    public DoctorMedicineRequest(){
        super(Type.DoctorMedicine.getValue());
    }
    
    public String getResult() {
        return Result;
    }

    public void setResult(String Result) {
        this.Result = Result;
    }
    
    
}
