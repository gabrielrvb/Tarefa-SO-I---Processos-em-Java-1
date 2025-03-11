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
import controller.KillController;

public class Main {

	public static void main(String[] args) {
		 KillController controller = new KillController();
	        
	        while (true) {
	            String opcao = JOptionPane.showInputDialog(
	                "Escolha uma opção:\n" +
	                "1 - Listar processos\n" +
	                "2 - Matar processo por PID\n" +
	                "3 - Matar processo por Nome\n" +
	                "4 - Sair"
	            );

	            if (opcao == null || opcao.equals("4")) {
	                System.out.println("Encerrando o programa...");
	                
	                break;
	            }

	            switch (opcao) {
	                case "1":
	                    System.out.println("Listando processos...");
	                    controller.listaProcessos();
	                    
	                    break;

	                case "2":
	                    String pidStr = JOptionPane.showInputDialog("Digite o PID do processo:");
	                    try {
	                        int pid = Integer.parseInt(pidStr);
	                        System.out.println("Tentando finalizar o processo com PID: " + pid);
	                        controller.mataPid(pid);
	                        
	                    } catch (NumberFormatException e) {
	                        System.err.println("Erro: PID inválido.");
	                    }
	                    
	                    break;

	                case "3":
	                    String nome = JOptionPane.showInputDialog("Digite o nome do processo:");
	                    if (nome != null && !nome.trim().isEmpty()) {
	                        System.out.println("Tentando finalizar o processo: " + nome);
	                        controller.mataNome(nome);
	                    } 
	                    else {
	                        System.err.println("Erro: Nome do processo inválido.");
	                    }
	                    
	                    break;

	                default:
	                    System.err.println("Opção inválida.");
	            }
	        }
	}	
}
