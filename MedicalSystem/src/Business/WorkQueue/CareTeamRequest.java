/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;

/**
 *
 * @author siyuanzhang
 */
public class CareTeamRequest extends WorkRequest{
    public CareTeamRequest(){
        super(Type.CareTeam.getValue());
    }
    
    private UserAccount assistantInTeam;

    public UserAccount getAssistantInTeam() {
        return assistantInTeam;
    }

    public void setAssistantInTeam(UserAccount assistantInTeam) {
        this.assistantInTeam = assistantInTeam;
    }
    
    
}
