/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ManageAirliners.ManageFlights.BookCustomerReservation;


import Business.Airplane;
import Business.Customer;
import Business.CustomerDirectory;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import static jdk.nashorn.internal.objects.NativeJava.type;

/**
 *
 * @author Keyu Liu
 */
public class ViewCustomerDiretoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewCustomerDiretoryJPanel
     */
    private JPanel CardSequenceForFlightJPanel;
    private CustomerDirectory customerDirectory;

    public ViewCustomerDiretoryJPanel(JPanel CardSequenceForFlightJPanel,CustomerDirectory customerDirectory) {
        initComponents();
        this.CardSequenceForFlightJPanel = CardSequenceForFlightJPanel;
        this.customerDirectory = customerDirectory;
        populateTable();
    }
    public void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel) tblCustomer.getModel();
        dtm.setRowCount(0);
        for(Customer customer: customerDirectory.getCustomerDirectory()){
        int col = customer.getSeatColumn();
        String type = customer.getSeatType();
        int rowNum = customer.getSeatRowNum();
        
            int colNum = 0;
            if (col == 1 && type == "Window")
            colNum = 0;    
            if(col == 1 && type =="Middle")
             colNum = 1;         
            if(col ==1 && type == "Aisle")
                colNum = 2; 
        
            if (col == 2 && type == "Window")
                colNum = 3; 
        
            if (col == 2 && type == "Middle")
                colNum = 4; 
         
            if (col == 2 && type == "Aisle")
                colNum = 5; 

        Object[] row = new Object[4];
            row[0] = customer;
            row[1] = customer.getAirplanePicked() ;
            row[2] = colNum;
            row[3] = rowNum;       
            dtm.addRow(row);
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
        tblCustomer = new javax.swing.JTable();

        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name", "Airplane", "Seat Column", "Seat Row"
            }
        ));
        jScrollPane1.setViewportView(tblCustomer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(294, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCustomer;
    // End of variables declaration//GEN-END:variables
}