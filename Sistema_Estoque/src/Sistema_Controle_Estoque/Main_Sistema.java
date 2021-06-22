package Sistema_Controle_Estoque;


import java.awt.EventQueue;
import Apresentacao.Tela_Principal;
import Persistencia.Conection;

/**
 * Launch the application.
 */
public class Main_Sistema{

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Tela_Principal frame = new Tela_Principal();
                    frame.setVisible(true);

                    //ALTERAR A SENHA DO ROOT QUE ESTÁ NA CLASSE conexaoBD DO PACOTE persistencia PARA CRIAR O BD E AS TABELAS
                    Conection conectar = new Conection();
                    conectar.conectar_BD();
                   

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}