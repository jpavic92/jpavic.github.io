/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.gui;

import hr.algebra.utils.IconUtils;
import hr.algebra.utils.MessageUtils;
import hr.cinestar.dal.Repository;
import hr.cinestar.dal.RepositoryFactory;
import hr.cinestar.model.Genre;
import hr.cinestar.model.Movie;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import hr.cinestar.model.MovieTableModel;
import hr.cinestar.model.PanelClosingListener;
import hr.cinestar.model.Person;
import java.awt.Desktop;
import java.awt.event.ItemEvent;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Josip
 */
public class MoviesPanel extends javax.swing.JPanel {
    
    private static final String DEFAULT_POSTER_PATH = "/assets/fimlstrip.jpg";
    private Repository repo;
    private MovieTableModel movieModel;
    
    private List<Movie> movies;
    private final List<Movie> filteredByLetters = new ArrayList<>();
    List<Movie> filteredByGenre = new ArrayList<>();
    private List<JTextComponent> textFields;
    private Movie selectedMovie;
    private boolean changes = false;
    
    

    /**
     * Creates new form MoviesPanel
     */
    public MoviesPanel() {
        initComponents();
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
        tblMovies = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfDirectors = new javax.swing.JTextField();
        tfGenres = new javax.swing.JTextField();
        lblPoster = new javax.swing.JLabel();
        btnGoTo = new javax.swing.JButton();
        tfBeginningDate = new javax.swing.JTextField();
        tfOriginalTitle = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbFilterGenre = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        taActors = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        tfFilter = new javax.swing.JTextField();

        tblMovies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tblMovies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblMoviesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblMovies);

        btnUpdate.setText("Update movie");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete movie");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setText("Add movie");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(153, 0, 0));
        lblTitle.setText("Title:");

        jLabel3.setText("Original title:");

        jLabel4.setText("Description:");

        jLabel5.setText("Directors:");

        jLabel6.setText("Actors:");

        jLabel7.setText("Genres:");

        jLabel8.setText("Beginning date:");

        tfDirectors.setEditable(false);

        tfGenres.setEditable(false);

        btnGoTo.setText("Go to website");
        btnGoTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoToActionPerformed(evt);
            }
        });

        tfBeginningDate.setEditable(false);

        tfOriginalTitle.setEditable(false);

        jLabel1.setText("Filter by genre:");

        cbFilterGenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbFilterGenre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFilterGenreItemStateChanged(evt);
            }
        });

        taDescription.setColumns(20);
        taDescription.setLineWrap(true);
        taDescription.setRows(5);
        jScrollPane3.setViewportView(taDescription);

        taActors.setEditable(false);
        taActors.setColumns(20);
        taActors.setLineWrap(true);
        taActors.setRows(2);
        jScrollPane2.setViewportView(taActors);

        jLabel2.setText("Filter by letters:");

        tfFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFilterKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfBeginningDate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addComponent(tfDirectors, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tfGenres, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGoTo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfOriginalTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbFilterGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblPoster, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tfFilter))))
                        .addGap(54, 54, 54))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfOriginalTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDirectors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfGenres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tfBeginningDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnGoTo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPoster, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbFilterGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblMoviesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMoviesMouseReleased
        clearForm();
        
        int selectedRow = tblMovies.getSelectedRow();
        int movieId = (int)tblMovies.getValueAt(selectedRow, 0);
        
        try {
            Optional<Movie> optMovie = repo.selectMovie(movieId);
            selectedMovie = optMovie.get();
            fillForm();
        }
        catch (Exception e) {
            Logger.getLogger(MoviesPanel.class.getName()).log(Level.SEVERE, null, e);
            MessageUtils.showErrorMessage("Error", "Unable to show movie");
        }
    }//GEN-LAST:event_tblMoviesMouseReleased

    private void btnGoToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoToActionPerformed
        if (selectedMovie == null) {
            MessageUtils.showInformationMessage("No movie selected", "Please select a movie");
            return;
        }
        
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI(selectedMovie.getLink()));
            } catch (URISyntaxException ex) {
                Logger.getLogger(MoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Incorrect url adress");
            } catch (IOException ex) {
                Logger.getLogger(MoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to browse URI");
            }
        }
    }//GEN-LAST:event_btnGoToActionPerformed

    private void cbFilterGenreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFilterGenreItemStateChanged
            filteredByGenre.clear();
        if (cbFilterGenre.getSelectedIndex() != 0 && evt.getStateChange() == ItemEvent.SELECTED) {
            filteredByGenre = new ArrayList();
            Genre selectedGenre = (Genre)evt.getItem();
            
            filteredByGenre.addAll(movies.stream()
            .filter(movie -> movie.getGenres()
            .contains(selectedGenre))
            .collect(Collectors.toList()));
            
            movieModel.setMovies(filteredByGenre);
        }
        else{
            movieModel.setMovies(movies);
        }
    }//GEN-LAST:event_cbFilterGenreItemStateChanged

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (selectedMovie == null) {
            MessageUtils.showInformationMessage("No movie selected", "Please select a movie");
            return;
        }
        
        if (MessageUtils.showConfirmationMessage("Delete movie?", "Are you sure?") == JOptionPane.YES_OPTION) {
            try {
                repo.deleteMovie(selectedMovie.getId());
                movies.remove(selectedMovie); // ovdje se može pozvati ažurirana baza ali nisam siguran zašto bih radio konekciju kad je ovako brže i ne čini se manje sigurno
                movieModel.setMovies(movies);
                
                File posterFile = new File(selectedMovie.getPosterPath());
                
                if (posterFile.delete()) {
                    MessageUtils.showInformationMessage("Success", "Movie \"" + selectedMovie.getTitle() + "\" has been deleted");
                }
                
                clearForm();
                
            } catch (Exception ex) {
                Logger.getLogger(MoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to delete the movie");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        EditMoviesDialog editMoviesDialog = new EditMoviesDialog((JFrame)this.getRootPane().getParent(), true, this);
        /*editMoviesDialog.addListener(new MoviePanelClosingListener());*/
        editMoviesDialog.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (selectedMovie == null) {
            MessageUtils.showInformationMessage("No movie selected", "Please select a movie");
            return;
        }
        new EditMoviesDialog((JFrame)this.getRootPane().getParent(), true, this, selectedMovie)
                .setVisible(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tfFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFilterKeyReleased
            List<Movie> listToFilter;
            if (cbFilterGenre.getSelectedIndex() == 0) {
                listToFilter = movies;
            }
            else{
                listToFilter = filteredByGenre;
            }
            
            filteredByLetters.clear();
            listToFilter.stream().filter(movie -> movie.getTitle().toLowerCase().startsWith(tfFilter.getText().toLowerCase().trim())).forEach(movie -> filteredByLetters.add(movie));
            movieModel.setMovies(filteredByLetters);
    }//GEN-LAST:event_tfFilterKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGoTo;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbFilterGenre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblPoster;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextArea taActors;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTable tblMovies;
    private javax.swing.JTextField tfBeginningDate;
    private javax.swing.JTextField tfDirectors;
    private javax.swing.JTextField tfFilter;
    private javax.swing.JTextField tfGenres;
    private javax.swing.JTextField tfOriginalTitle;
    // End of variables declaration//GEN-END:variables

    private void init() {
        try {
            initTextFields();
            initRepo();
            initTable();
            loadTableModel();
            initFilter();
        } catch (Exception ex) {
            Logger.getLogger(MoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Uncoverable error", "Unable to initiate the form");
            System.exit(1);
        }
    }

    private void initRepo() throws Exception {
       repo = RepositoryFactory.getRepository();
    }
    
    private void initTable() throws Exception{
        tblMovies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblMovies.setRowHeight(27);
        tblMovies.setAutoCreateRowSorter(true);
        movies = repo.selectMovies();
        movieModel = new MovieTableModel(movies);
        tblMovies.setModel(movieModel);
        tblMovies.getColumnModel().getColumn(0).setMaxWidth(45);
    }
    
     private void loadTableModel() throws Exception {
        movies = repo.selectMovies();
        movieModel.setMovies(movies);
    }

    private void clearForm() {
        textFields.forEach(field -> field.setText(""));
        selectedMovie = null;
        //set default icon
        
    }

    private void initTextFields() {
        textFields = Arrays.asList(tfOriginalTitle, taDescription, taActors, tfDirectors, tfGenres, tfBeginningDate);
        taDescription.setWrapStyleWord(true);
    }

    private void fillForm() throws IOException {
        tfOriginalTitle.setText(selectedMovie.getOriginalTitle());
        taDescription.setText(selectedMovie.getDescription());
        tfBeginningDate.setText(Movie.DATE_FORMAT.format(selectedMovie.getBeginningDate()));
        lblTitle.setText(selectedMovie.getTitle());
        
        taActors.setText(setActors());
        taActors.setCaretPosition(0);
        
        tfDirectors.setText(setDirectors());
        taDescription.setCaretPosition(0);
        
        tfGenres.setText(setGenres());
        
        handlePoster();
        
    }

    private String setActors() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < selectedMovie.getActors().size(); i++) {
            Person actor = selectedMovie.getActors().get(i);
            
            if (i == selectedMovie.getActors().size() - 1) {
                sb.append(actor.getFirstName());
                sb.append(" ");
                sb.append(actor.getLastName());
            }
            else{
                sb.append(actor.getFirstName());
                sb.append(" ");
                sb.append(actor.getLastName());
                sb.append(", ");
            }
        }
        return sb.toString().trim();
    }

    private String setDirectors() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < selectedMovie.getDirectors().size(); i++) {
            Person director = selectedMovie.getDirectors().get(i);
            if (i == selectedMovie.getDirectors().size() - 1) {
                sb.append(director.getFirstName());
                sb.append(" ");
                sb.append(director.getLastName());
            }
            else{
                sb.append(director.getFirstName());
                sb.append(" ");
                sb.append(director.getLastName());
                sb.append(", ");
            }
        }
        return sb.toString().trim();
    }

    private String setGenres() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < selectedMovie.getGenres().size(); i++) {
            Genre genre = selectedMovie.getGenres().get(i);
            
           if (i == selectedMovie.getGenres().size() - 1) {
                sb.append(genre.getName());
            }
            else{
                sb.append(genre.getName());
                sb.append(", ");
            }
        }
        
        return sb.toString();
    }

    private void handlePoster() throws IOException {
        
       
        ImageIcon poster = IconUtils.createIcon(selectedMovie.getPosterPath(), lblPoster.getWidth(), lblPoster.getHeight());
        try {
            lblPoster.setIcon(poster);
        } catch (Exception e) {
            //set CORRUPTED DATA image
        }
        
    }

    private void initFilter() throws Exception {
        List<Genre> genres = repo.selectGenres();
        Genre fakeGenre = new Genre("---Select genre---");
        genres.add(0, fakeGenre);
        DefaultComboBoxModel model = new DefaultComboBoxModel(genres.toArray());
        cbFilterGenre.setModel(model);
    }
    
    public void refreshData() {
        try {
            clearForm();
            loadTableModel();
        } catch (Exception ex) {
            Logger.getLogger(MoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    public void setChanges(boolean changes){
        this.changes = changes;
    }

    /*  private class MoviePanelClosingListener implements PanelClosingListener {
    
    public MoviePanelClosingListener() {
    }
    
    @Override
    public void refreshData() {
    clearForm();
    loadTableModel();
    }
    }*/
}