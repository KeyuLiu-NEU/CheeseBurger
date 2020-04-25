/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author raunak
 */
public class AssistantMedicineRequest extends WorkRequest{
    
    private String Result;
    
    public AssistantMedicineRequest(){
        super(Type.AssistantMedicine.getValue());
    }
    
    public String getResult() {
        return Result;
    }

    public void setResult(String Result) {
        this.Result = Result;
    }


}
