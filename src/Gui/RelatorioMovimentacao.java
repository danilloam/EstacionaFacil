/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RelatorioMovimentacao.java
 *
 * Created on 28/11/2011, 19:42:10
 */
package Gui;

import ClassesBasicas.Movimentacao;
import Fachada.Fachada;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danillo
 */
public class RelatorioMovimentacao extends javax.swing.JFrame {
Fachada fachada;
    ArrayList<Movimentacao> listaMovimentacaos;

    /** Creates new form RelatorioMovimentacao */
   

public RelatorioMovimentacao() {
    
 
        initComponents();
       listarMovimentacao();
      
}
public void listarMovimentacao(){




      DefaultTableModel modelo = (DefaultTableModel) Tabela_movimentacao.getModel();
        modelo.setNumRows(0);
        try {
           
            listaMovimentacaos = Fachada.obterInstancia().ListarMovimentacao();
            for (int i = 0; i < listaMovimentacaos.size(); i++) {
                modelo.addRow(new Object[]{
                            listaMovimentacaos.get(i).getFuncionario(),
                            listaMovimentacaos.get(i).getPlaca(),
                            listaMovimentacaos.get(i).getDt_entrada(),
                            listaMovimentacaos.get(i).getHorario_entrada(),
                            listaMovimentacaos.get(i).getDt_saida(),
                listaMovimentacaos.get(i).getHorario_saida(),
                listaMovimentacaos.get(i).getValor()});
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + erro);
        }
    }


    
//    

//    ///try {
//     //   fachada.Listar(movimentacao);
//     //   
//             for (int i = 0; i < fachada.obterInstancia().Listar(movimentacao).size(); i++) {
//            Tabela_movimentacao.set(new String[]{"" + fachada.Listar(movimentacao).get(i).getFuncionario(), fachada.Listar(movimentacao).get(i).getPlaca(),fachada.Listar(movimentacao).get(i).getDt_entrada(), fachada.Listar(movimentacao).get(i).getHr_entrada(),fachada.Listar(movimentacao).get(i).getDt_saida(), fachada.Listar(movimentacao).get(i).getHr_saida()});
//        }
//        } catch (Exception ex) {
//            Logger.getLogger(RelatorioMovimentacao.class.getName()).log(Level.SEVERE, null, ex);
//        }
// }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela_movimentacao = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estaciona Facil - Relatório");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setText("RELATÓRIO DE MOVIMENTAÇÕES");

        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Tabela_movimentacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Funcionário", "Placa", "Data de Entrada", "Hora de Entrada", "Data de Saída", "Hora de Saída", "Valor"
            }
        ));
        jScrollPane1.setViewportView(Tabela_movimentacao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
         
       
           java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new RelatorioMovimentacao().setVisible(true);
                 
            }
            
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabela_movimentacao;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}