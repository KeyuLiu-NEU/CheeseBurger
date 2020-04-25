/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

/**
 *
 * @author siyuanzhang
 */
public class Schedule {
    private String[] scheduleStatus;
    private String[] timePeriod;
    
    public Schedule(){
        
        this.scheduleStatus = new String[7];
        this.timePeriod = new String[7];
        timePeriod[0] = "9:00--10:00";
        timePeriod[1] = "1:00--11:00";
        timePeriod[2] = "11:00--12:00";
        timePeriod[3] = "14:00--15:00";
        timePeriod[4] = "15:00--16:00";
        timePeriod[5] = "16:00--17:00";
        timePeriod[6] = "17:00--18:00";
        for(int i = 0;i < scheduleStatus.length;i++)
            scheduleStatus[i] = "empty";
    }
    
    public String getTime(int num){
        return timePeriod[num];
    }
    
    public String getStatus(int num){
        return scheduleStatus[num];
    }
    
}
