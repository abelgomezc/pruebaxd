/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.ModelPersona;
import vistas.VistaMenuPrincipal;
import vistas.VistaPersonas;

/**
 *
 * @author Abel Gomez
 */
public class ControlPrincipal {

    VistaMenuPrincipal vistamenuprin;

    public ControlPrincipal(VistaMenuPrincipal vistamenuprin) {
        this.vistamenuprin = vistamenuprin;
            vistamenuprin.setVisible(true);
            EventQueue.invokeLater(() -> {
                FlatAnimatedLafChange.showSnapshot();
                FlatIntelliJLaf.setup();
                FlatLaf.updateUI();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
            });
        //  vistamenuprin.setVisible(true);
    }

    public void iniciaControl() {

        vistamenuprin.getBtncrudpersonas().addActionListener(l -> crudpersonas());
        vistamenuprin.getChbxmodooscuro().addActionListener(l -> modooscurro());
        //  vistamenuprin.getBtncrudproveedores().addActionListener(l->crudproveedores());
    }

    private void crudpersonas() {
        //Instancio las clases del Modelo y la Vista.

        ModelPersona modelopersona = new ModelPersona();
        VistaPersonas vistapersonas = new VistaPersonas();
        

        //Agregar Vista Personas al Desktop Pane.
        vistamenuprin.getjDesktopPaneprincipal().add(vistapersonas);
        ControllerPersona controlclientes = new ControllerPersona(modelopersona, vistapersonas);

        try {
            controlclientes.inciacontrol();
            //  ControllerPersona controladorCrudPersonas = new ControllerPersona(modeloCrudPersonas, vistaCrudPersonas);
            //  controladorCrudPersonas.iniciaControl();//Empezamos las escuchas a los eventos de la vista, Listeners.
        } catch (IOException ex) {
            Logger.getLogger(ControlPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void modooscurro() {

        if (vistamenuprin.getChbxmodooscuro().isSelected()) {
            EventQueue.invokeLater(() -> {
                FlatAnimatedLafChange.showSnapshot();
                FlatDarculaLaf.setup();
                FlatLaf.updateUI();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
            });
        } else {
            EventQueue.invokeLater(() -> {
                FlatAnimatedLafChange.showSnapshot();
                FlatLightLaf.setup();
                FlatLaf.updateUI();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
            });
        }

    }

}
