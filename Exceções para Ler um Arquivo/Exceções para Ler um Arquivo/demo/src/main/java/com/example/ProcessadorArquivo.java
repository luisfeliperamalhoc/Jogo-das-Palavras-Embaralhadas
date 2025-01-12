package com.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;


public class ProcessadorArquivo {
    static HashMap<String, String> leituraDeArquivos = new HashMap<>();
    
    
        public static  HashMap<String, String> processar(String txt) {
            try (BufferedReader br = new BufferedReader(new FileReader(txt))){
                String linha;
                while ((linha = br.readLine()) != null) {
                    if(linha.length()==0){
                        System.err.println("Arquivo Vazio");
                    }
                    String arquivoSemEspacos = linha.trim();
                    String[] arquivoPreProcessado = arquivoSemEspacos.split("->");
                    if ( arquivoPreProcessado.length==2){
                        leituraDeArquivos.put(arquivoPreProcessado[0],arquivoPreProcessado[1]);
                    }
                    else{
                        System.err.println("Linha mal formatada:" + linha );
                    }
                }
        } catch (IOException e ){
            System.err.println("Erro ao processar o arquivo" + e.getMessage());
        }
        return leituraDeArquivos;
        
    }

}

