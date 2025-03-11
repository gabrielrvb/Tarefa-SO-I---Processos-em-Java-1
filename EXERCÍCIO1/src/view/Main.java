/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author liver
 */
package view;

import javax.swing.JOptionPane;
import controller.RedesController;

public class Main {
	
    public static void main(String[] args) {
        RedesController redes = new RedesController();
        
        while (true) {
            String opcao = JOptionPane.showInputDialog("Escolha uma opção:\n1 - Exibir configuração de IP\n2 - Testar Ping\n3 - Sair");
            
            if (opcao == null || opcao.equals("3")) {
                System.out.println("Aplicação finalizada");
                break;
            }
            
            switch (opcao) {
                case "1" -> redes.ip();
                case "2" -> redes.ping();
                default -> System.out.println("Opcão Inválida");
            }
        }
    }
}