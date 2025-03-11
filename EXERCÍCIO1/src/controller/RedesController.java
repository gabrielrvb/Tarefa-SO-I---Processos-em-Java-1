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

public class RedesController {
    
    private String os() {
        return System.getProperty("os.name");
    }
    
    public void ip() {
        String so = os().toLowerCase();
        System.out.println("Sistema Operacional: " + os());
        String comando;
        
        if (so.contains("win")) {
            comando = "ipconfig";
        } 
        
        else {
            comando = "ifconfig";
        }
        
        try {
            @SuppressWarnings("deprecation")
			Process processo = Runtime.getRuntime().exec(comando);
            BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            String linha;
            
            while ((linha = leitor.readLine()) != null) {
                if (linha.contains("Adaptador") || linha.contains("adapter")) {
                    System.out.println(linha);
                }
                
                if (linha.contains("IPv4") || linha.contains("inet ")) {
                    System.out.println(linha);
                }
            }
            
            leitor.close();
            
        } catch (Exception e) {
            System.err.println("Erro ao executar comando: " + e.getMessage());
        }
    }
    
    public void ping() {
        String so = os().toLowerCase();
        String comando;
        
        if (so.contains("win")) {
            comando = "ping -4 -n 10 www.google.com.br";
        } 
        
        else {
            comando = "ping -4 -c 10 www.google.com.br";
        }
        
        try {
        	@SuppressWarnings("deprecation")
            Process processo = Runtime.getRuntime().exec(comando);
            BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            String linha;
            
            while ((linha = leitor.readLine()) != null) {
            	System.out.println("Linha recebida: " + linha); //depuração
                if (so.contains("win") && linha.contains("Média =")) {
                    System.out.println("Tempo médio do ping: " + linha.split("=")[1].trim());
                    
                } else if (!so.contains("win") && linha.contains("avg")) {
                    String[] partes = linha.split("/");
                    
                    if (partes.length >= 5) {
                        System.out.println("Tempo médio do ping: " + partes[4] + " ms");
                    }
                }
            }
            
            leitor.close();
            
        } catch (Exception e) {
            System.err.println("Erro ao executar comando: " + e.getMessage());
        }
    }
}