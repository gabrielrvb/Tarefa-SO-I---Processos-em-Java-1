/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author liver
 */
package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KillController {
	private String os() {
        return System.getProperty("os.name").toLowerCase();
    }
    
    public void listaProcessos() {
        String so = os();
        String comando = so.contains("win") ? "TASKLIST /FO TABLE" : "ps -ef";
        
        try {
        	@SuppressWarnings("deprecation")
            Process processo = Runtime.getRuntime().exec(comando);
            BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            String linha;
            
            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }
            
            leitor.close();
            
        } catch (Exception e) {
            System.err.println("Erro ao listar processos: " + e.getMessage());
        }
    }
    
	public void mataPid(int pid) {
        String so = os();
        String comando = so.contains("win") ? "TASKKILL /PID " + pid : "kill -9 " + pid;
        
        try {
            Runtime.getRuntime().exec(comando);
            System.out.println("Processo com PID " + pid + " finalizado.");
            
        } catch (Exception e) {
            System.err.println("Erro ao matar processo: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("deprecation")
	public void mataNome(String nome) {
        String so = os();
        String comando = so.contains("win") ? "TASKKILL /IM " + nome : "pkill -f " + nome;
        
        try {
            Runtime.getRuntime().exec(comando);
            System.out.println("Processo " + nome + " finalizado.");
            
        } catch (Exception e) {
            System.err.println("Erro ao matar processo: " + e.getMessage());
        }
    }
}