/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AssistantRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.AssistantOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AssistantMedicineRequest;
import Business.WorkQueue.CareTeamRequest;
import Business.WorkQueue.ReserveAssistantRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class AssistantWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private AssistantOrganization labOrganization;
    private Network network;
    private Enterprise enterprise;
    
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public AssistantWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystem business, Network network, Enterprise enterprise) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.labOrganization = (AssistantOrganization)organization;
        this.network = network;
        this.enterprise = enterprise;
        populateAppointmentTable();
        populateCareTeamTable();
        populateMedicineRequestTable();
    }
    
    public void populateAppointmentTable(){
        DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : network.getWorkQueue().getWorkRequestList()){
            if(request.getType().equals(WorkRequest.Type.ReserveAssistant.getValue())){
                Object[] row = new Object[4];
                row[0] = request;
                row[1] = request.getSender().getEmployee().getName();
                row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                row[3] = request.getStatus();

                model.addRow(row);
            }
        }
    }
    
    public void populateCareTeamTable(){
        DefaultTableModel model = (DefaultTableModel)careTeamRequestJTable.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : network.getWorkQueue().getWorkRequestList()){
            if(request.getType().equals(WorkRequest.Type.CareTeam.getValue())){
                Object[] row = new Object[4];
                row[0] = request;
                row[1] = request.getSender().getEmployee().getName();
                row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                row[3] = request.getStatus();

                model.addRow(row);
            }
        }
    }
    
    public void populateMedicineRequestTable(){
            
        DefaultTableModel model = (DefaultTableModel)medicineRequestJTable.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : network.getWorkQueue().getWorkRequestList()){
            if(request.getType().equals(WorkRequest.Type.AssistantMedicine.getValue())){
                Object[] row = new Object[4];
                row[0] = request;
                row[1] = request.getSender().getEmployee().getName();
                row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                row[3] = request.getStatus();

                model.addRow(row);
            }
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        assignJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        requestMedicineJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        careTeamRequestJTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        medicineRequestJTable = new javax.swing.JTable();
        joinCareTeamJButton = new javax.swing.JButton();
        sendBackJButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 375, 96));

        assignJButton.setText("Assign patient to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        processJButton.setText("Inquiry");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        requestMedicineJButton.setText("Request Medicine");
        requestMedicineJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestMedicineJButtonActionPerformed(evt);
            }
        });
        add(requestMedicineJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, -1, -1));

        careTeamRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Doctor", "Assistant", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(careTeamRequestJTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 375, 96));

        medicineRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(medicineRequestJTable);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 375, 96));

        joinCareTeamJButton.setText("Join Care Team");
        joinCareTeamJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinCareTeamJButtonActionPerformed(evt);
            }
        });
        add(joinCareTeamJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        sendBackJButton.setText("Send Back Request");
        sendBackJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBackJButtonActionPerformed(evt);
            }
        });
        add(sendBackJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        WorkRequest request = (WorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setStatus("Pending");
        populateAppointmentTable();
        
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        
        int selectedRow = workRequestJTable.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        ReserveAssistantRequest request = (ReserveAssistantRequest)workRequestJTable.getValueAt(selectedRow, 0);
     
        request.setStatus("Processing");
        
        AssistantProcessAppointmentRequestJPanel processWorkRequestJPanel = new AssistantProcessAppointmentRequestJPanel(userProcessContainer, request);
        userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_processJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateAppointmentTable();
        populateCareTeamTable();
        populateMedicineRequestTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void requestMedicineJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestMedicineJButtonActionPerformed
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("RequestMedicalDeviceJPanel", new AssistantRequestMedicineJPanel(userProcessContainer, userAccount, enterprise, network));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_requestMedicineJButtonActionPerformed

    private void joinCareTeamJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinCareTeamJButtonActionPerformed
        int selectedRow = careTeamRequestJTable.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        WorkRequest request = (WorkRequest)careTeamRequestJTable.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setStatus("Adding team member");
        populateAppointmentTable();
    }//GEN-LAST:event_joinCareTeamJButtonActionPerformed

    private void sendBackJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBackJButtonActionPerformed
        int selectedRow = careTeamRequestJTable.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        CareTeamRequest request = (CareTeamRequest)careTeamRequestJTable.getValueAt(selectedRow, 0);
     
        request.setStatus("Team complete");
        request.getSender().setCareTeamStatus(Boolean.TRUE);
        
    }//GEN-LAST:event_sendBackJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JTable careTeamRequestJTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton joinCareTeamJButton;
    private javax.swing.JTable medicineRequestJTable;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton requestMedicineJButton;
    private javax.swing.JButton sendBackJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
