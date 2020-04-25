/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author siyuanzhang
 */
public class MedicalDeviceWorkRequest extends WorkRequest{
    private String Result;
    private int medicalDeviceANum;
    private int medicalDeviceBNum;
    
    public MedicalDeviceWorkRequest(){
        super(Type.MedicalDevice.getValue());
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String Result) {
        this.Result = Result;
    }

    public int getMedicalDeviceANum() {
        return medicalDeviceANum;
    }

    public void setMedicalDeviceANum(int medicalDeviceANum) {
        this.medicalDeviceANum = medicalDeviceANum;
    }

    public int getMedicalDeviceBNum() {
        return medicalDeviceBNum;
    }

    public void setMedicalDeviceBNum(int medicalDeviceBNum) {
        this.medicalDeviceBNum = medicalDeviceBNum;
    }
    
    
}
