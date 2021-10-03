package view;

import javax.swing.JOptionPane;

public class Tela {
    public void mostrar(String mensagem, String titulo, int icone){
        JOptionPane.showMessageDialog(
            null,       // Componente pai
            mensagem,   // Menssagem
            titulo,     // Titulo da janela
            icone          // Icone
            );

        // -1 Plane
        // 0 Error
        // 1 Information
        // 2 Warning
        // 3 Question
    }

    public String informar(String mensagem, String titulo, int icone) {
        return JOptionPane.showInputDialog(
            null, 
            mensagem, 
            titulo, 
            icone
            );
    }
    
    public Integer confirmar(String mensagem, String titulo, int icone) {
        return JOptionPane.showConfirmDialog(
            null, 
            mensagem, 
            titulo,
            JOptionPane.YES_NO_OPTION, 
            icone
            );
    }
}