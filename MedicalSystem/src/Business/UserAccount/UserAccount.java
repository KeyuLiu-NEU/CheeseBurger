/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author raunak
 */
public class UserAccount {
    
    private String username;
    private String password;
    private Employee employee;
    private Role role;
    //private WorkQueue workQueue;
    private Schedule schedule;
    private Boolean surgeryStatus = false;
    private Boolean careTeamStatus = false;
    private Boolean medicalDeviceStatus = false;
    
    public UserAccount() {
        //workQueue = new WorkQueue();
        this.schedule = new Schedule();
        this.surgeryStatus = false;
        this.medicalDeviceStatus = false;
        this.careTeamStatus = false;
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }
    
    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Boolean getSurgeryStatus() {
        return surgeryStatus;
    }

    public void setSurgeryStatus(Boolean surgeryStatus) {
        this.surgeryStatus = surgeryStatus;
    }

    public Boolean getCareTeamStatus() {
        return careTeamStatus;
    }

    public void setCareTeamStatus(Boolean careTeamStatus) {
        this.careTeamStatus = careTeamStatus;
    }

    public Boolean getMedicalDeviceStatus() {
        return medicalDeviceStatus;
    }

    public void setMedicalDeviceStatus(Boolean medicalDeviceStatus) {
        this.medicalDeviceStatus = medicalDeviceStatus;
    }
    
    
    
    @Override
    public String toString() {
        return username;
    }
    
    
    
}