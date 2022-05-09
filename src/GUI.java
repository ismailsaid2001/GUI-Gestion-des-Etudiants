import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Vector;

public class GUI {
    Vector<Etudiant> Etudiants=new Vector<Etudiant>() ;
    JFrame f; // the main frame
    //Buttons :
    JButton b_add;
    JButton b_remove;
    JButton b_update;
    JButton b_affiche;
    JButton b_serialize;
    JRadioButton Homme;
    JRadioButton Femme ;
    JComboBox jComboBox_Filiere;
    //Panels
    JPanel pnorth;
    JPanel psouth;
    JPanel peast;
    //Labels
    JLabel Label_Nom;
    JLabel Label_Prenom;
    JLabel Label_Sexe;
    JLabel Label_Filiere;
    //TextFiels
    JTextField Nom;
    JTextField Prenom;
    JTextField Sexe;
    JTextField ID;
    //
    JTextArea Noms;
    GUI() {
        f = new JFrame("Gestion");//construction of the frame
        //North Zone
        pnorth = new JPanel();
        peast = new JPanel();
        psouth = new JPanel();
        f.setLayout(new BorderLayout());
        pnorth.setLayout(new GridLayout(2, 5,20,20));
        // constructing labels
        Label_Nom = new JLabel("Nom");
        Label_Prenom = new JLabel("prenom");
        Label_Sexe = new JLabel("Sexe");
        Label_Filiere = new JLabel("Filiere");
        //constructing TextFields
        Nom  = new JTextField();
        Prenom  = new JTextField();
        Sexe   = new JTextField();
        ID=new JTextField() ;
        //constructing JRadioButton
        Homme =new JRadioButton("H") ;
        Femme=new JRadioButton("F") ;
        //contructing JCombobox :
        jComboBox_Filiere=new JComboBox() ;
        jComboBox_Filiere.addItem("RT");
        jComboBox_Filiere.addItem("GL");
        jComboBox_Filiere.addItem("IIA");
        jComboBox_Filiere.addItem("IMI");
        //
        Noms=new JTextArea("Liste Des Etudiants") ;

        //constrcting Buttons
        b_update=new JButton("Modifier") ;
        b_add=new JButton("ajouter") ;
        b_remove=new JButton("effacer") ;
        b_affiche=new JButton("afficher") ;
        b_serialize=new JButton("serializer") ;
        // adding Labels and !text fields in the grid
        //first row
        pnorth.add(Label_Nom);
        pnorth.add(Nom);
        pnorth.add(Label_Sexe);
        pnorth.add(Homme);
        pnorth.add(Femme);
        //second row

        pnorth.add(Label_Prenom);
        pnorth.add(Prenom);
        pnorth.add(Label_Filiere);
        pnorth.add(jComboBox_Filiere);
        pnorth.add(ID);
        f.add(pnorth, BorderLayout.NORTH); //adding pnorth panel  in the north of the frame
        ///
        peast.add(b_add);
        peast.add(b_update);
        peast.add(b_remove);
        peast.add(b_affiche) ;
        peast.add(b_serialize) ;
        f.add(peast, BorderLayout.EAST); //adding pnorth panel  in the north of the frame
        //
        f.add(Noms,BorderLayout.CENTER) ;
        //
        MonEcouteur me = new MonEcouteur(this);
        //adding ActionListener for Buttons and Jcomboboxes
        b_serialize.addActionListener(me);
        b_add.addActionListener(me);
        b_remove.addActionListener(me);
        b_update.addActionListener(me);
        b_affiche.addActionListener(me);
        f.setSize(500,500);
        //f.pack();//The pack method sizes the frame so that all its contents are at or above their preferred sizes
        f.setVisible(true); // to make visible the frame

    }

    public static void main(String[] args) throws IOException {
        GUI mf = new GUI();
    }
}


