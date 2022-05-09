import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MonEcouteur implements ActionListener {
    GUI ihm;

    MonEcouteur(GUI G) {
        ihm = G;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ihm.b_add) {
            String Nom = ihm.Nom.getText();
            String Prenom = ihm.Prenom.getText();
            String Sexe="";
            if(ihm.Homme.isSelected()) {
                Sexe = "Homme";
            }
            else if (ihm.Femme.isSelected()) {
                Sexe="Femme" ;
            }
            String Filiere = (String) ihm.jComboBox_Filiere.getSelectedItem();
            int id = 0;
            String id_string = ihm.ID.getText();
//cas ou id n'est pas transformable en entier
            try {
                id = Integer.parseInt(id_string);
            } catch (NumberFormatException e1) {

                System.err.println("Unable to convert String  " + id_string
                        + " to int. A NumberFormatException Occured, Ensure the string contains only valid numbers " + e);

            }

            Etudiant E1 = new Etudiant(Nom, Prenom, Sexe, Filiere, id);
            if (ihm.Etudiants.contains(E1)) {
                JOptionPane.showMessageDialog(ihm.f, "l'Etudiant  existe deja");
            } else if (Nom.length() == 0 || Prenom.length() == 0 || Sexe.length() == 0 || Filiere.length() == 0) {
                JOptionPane.showMessageDialog(ihm.f, "veuillez remplir toutes les cases!!");
            } else {
                ihm.Etudiants.addElement(E1);
            }
        } else if (e.getSource() == ihm.b_remove) {
            String Nom = ihm.Nom.getText();
            String Prenom = ihm.Prenom.getText();
            String Sexe = "";
            if(ihm.Homme.isSelected()) {
                Sexe = "Homme";
            }
            else if (ihm.Femme.isSelected()) {
                Sexe="Femme" ;
            }
            String Filiere = (String) ihm.jComboBox_Filiere.getSelectedItem();
            int id = 0;
            String year_string = ihm.ID.getText();
//cas ou year n'est pas transformable en entier
            try {
                id = Integer.parseInt(year_string);
            } catch (NumberFormatException e1) {

                System.err.println("Unable to convert String  " + year_string
                        + " to int. A NumberFormatException Occured, Ensure the string contains only valid numbers " + e);
            }


            Etudiant E1 = new Etudiant(Nom, Prenom, Sexe, Filiere, id);
            if (ihm.Etudiants.contains(E1)) {
                ihm.Etudiants.remove(E1);
            } else {
                JOptionPane.showMessageDialog(ihm.f, "l'Etudiant  n'existe pas dans la liste!!");
            }
        } else if (e.getSource() == ihm.b_update) {
            String Nom = ihm.Nom.getText();
            String Prenom = ihm.Prenom.getText();
            String Sexe = "";
            if(ihm.Homme.isSelected()) {
                Sexe = "Homme";
            }
            else if (ihm.Femme.isSelected()) {
                Sexe="Femme" ;
            }
            String Filiere = (String) ihm.jComboBox_Filiere.getSelectedItem();
            int id = 0;
            Etudiant etu=new Etudiant();
            String year_string = ihm.ID.getText();
//cas ou year n'est pas transformable en entier
            try {
                id = Integer.parseInt(year_string);
            } catch (NumberFormatException e1) {

                System.err.println("Unable to convert String  " + year_string
                        + " to int. A NumberFormatException Occured, Ensure the string contains only valid numbers " + e);
            }
            Etudiant E1 = new Etudiant(Nom, Prenom, Sexe, Filiere, id);

                for (Etudiant etudiant : ihm.Etudiants) {
                    if (etudiant.ID == id) {
                        etu = etudiant;
                    }
                }
                if(ihm.Etudiants.contains(etu)) {
                etu.ID=id;
                etu.Filiere=Filiere;
                etu.Nom=Nom;
                etu.Sexe=Sexe;
                etu.Prenom=Prenom;
            } else {
                JOptionPane.showMessageDialog(ihm.f, "l'etudiant n'existe pas malheureusement!!");
            }
        }
        else if(e.getSource()==ihm.b_affiche) {
            ihm.Noms.setText("");
            for (Etudiant etudiant : ihm.Etudiants) {
                ihm.Noms.append(etudiant.toString() + "\n");
            }

        }
        else if (e.getSource()==ihm.b_serialize) {
            String Nom = ihm.Nom.getText();
            String Prenom = ihm.Prenom.getText();
            String Sexe="";
            if(ihm.Homme.isSelected()) {
                Sexe = "Homme";
            }
            else if (ihm.Femme.isSelected()) {
                Sexe="Femme" ;
            }
            String Filiere = (String) ihm.jComboBox_Filiere.getSelectedItem();
            int id = 0;
            String id_string = ihm.ID.getText();
//cas ou id n'est pas transformable en entier
            try {
                id = Integer.parseInt(id_string);
            } catch (NumberFormatException e1) {

                System.err.println("Unable to convert String  " + id_string
                        + " to int. A NumberFormatException Occured, Ensure the string contains only valid numbers " + e);

            }

            Etudiant E1 = new Etudiant(Nom, Prenom, Sexe, Filiere, id);
            FileOutputStream fileoutputstream= null;
            try {
                fileoutputstream = new FileOutputStream("Etudiant.ser");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            ObjectOutputStream objectoutputstream = null;
            try {
                objectoutputstream = new
                        ObjectOutputStream(fileoutputstream);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                objectoutputstream.writeObject(E1);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                objectoutputstream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                fileoutputstream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println("Object has been serialized");
        }

    }
}
