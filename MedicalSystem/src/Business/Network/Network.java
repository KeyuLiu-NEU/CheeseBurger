/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author MyPC1
 */
public class Network {
    private String name;
    private EnterpriseDirectory enterpriseDirectory;
    private WorkQueue workQueue;
    private int medicalDeviceA = 15;
    private int medicalDeviceB = 20;
    
    public Network(){
        enterpriseDirectory=new EnterpriseDirectory();
        this.workQueue = new WorkQueue();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public int getMedicalDeviceA() {
        return medicalDeviceA;
    }

    public void setMedicalDeviceA(int medicalDeviceA) {
        this.medicalDeviceA = medicalDeviceA;
    }

    public int getMedicalDeviceB() {
        return medicalDeviceB;
    }

    public void setMedicalDeviceB(int medicalDeviceB) {
        this.medicalDeviceB = medicalDeviceB;
    }
    
    public void medicalDeviceAPlusOne(){
        this.medicalDeviceA++;
    }
    public void medicalDeviceBPlusOne(){
        this.medicalDeviceB++;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
}
