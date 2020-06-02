/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.gui;

import hr.cinestar.dal.Repository;
import hr.cinestar.model.Genre;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;

/**
 *
 * @author Josip
 */
public class AddGenreDialog extends javax.swing.JDialog {
    
    private Set<Genre> allGenresSet;
    private Set<Genre> genresSet;
    private Set<Genre> notSelectedGenres;
    private final DefaultListModel<Genre> genresModel = new DefaultListModel<>();
    private final EditMoviesDialog parent;
    private Genre selectedGenre;

    /**
     * Creates new form AddGenreDialog
     */
    public AddGenreDialog(JDialog parent, boolean modal, Collection<Genre> genres, Collection<Genre> allGenres) {
        super(parent, modal);
        initComponents();
        this.parent = (EditMoviesDialog)parent;
        allGenresSet = new HashSet<>(allGenres);
        genresSet = new HashSet<>(genres);
        init();
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
        lsGenres = new javax.swing.JList<>();
        tfGenreName = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add a genre");

        lsGenres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lsGenresMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(lsGenres);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(tfGenreName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfGenreName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lsGenresMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsGenresMouseReleased
        clearForm();
        selectedGenre = lsGenres.getSelectedValue();
        tfGenreName.setText(selectedGenre.getName());
    }//GEN-LAST:event_lsGenresMouseReleased

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Genre genre = new Genre(tfGenreName.getText().trim());
        if (allGenresSet.contains(genre)) {
            genre.setId(selectedGenre.getId());
        }
        
        parent.addGenreToList(genre);
        notSelectedGenres.remove(genre);
        loadGenresModel();
        clearForm();
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Genre> lsGenres;
    private javax.swing.JTextField tfGenreName;
    // End of variables declaration//GEN-END:variables

    private void init() {
        makeDifference();
        loadGenresModel();
       
    }

    private void loadGenresModel() {
        genresModel.clear();
        notSelectedGenres.forEach(genre -> genresModel.addElement(genre));
        lsGenres.setModel(genresModel);
    }

    private void makeDifference() {
        notSelectedGenres = allGenresSet
                            .stream()
                            .filter(genre -> !genresSet.contains(genre))
                            .collect(Collectors.toSet());
    }

    private void clearForm() {
        tfGenreName.setText("");
    }
}