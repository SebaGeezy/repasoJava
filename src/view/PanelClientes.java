package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class PanelClientes extends JPanel implements ListSelectionListener{
    
    private Interfaz interfaz;
    private JList<String> listaClientes;

    public PanelClientes(Interfaz i) {
        super();
        setLayout(new GridLayout());
        setBorder(new TitledBorder("Clientes"));
        interfaz = i;

        listaClientes = new JList<>();
        listaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaClientes.addListSelectionListener(this);
        add(listaClientes);
    }

    public void updateListClientes(String[] listado){
        listaClientes.setListData(listado);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {            
            interfaz.updatePanelWallet(listaClientes.getSelectedIndex());
        }
    }

}
