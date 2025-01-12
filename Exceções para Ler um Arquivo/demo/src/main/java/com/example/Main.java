package com.example;

import java.util.Map;

public class Main {
    public static void main(String[] args){
        String caminho = "arquivoTeste.txt";
        Map<String, String> resultado = ProcessadorArquivo.processar(caminho);
        System.out.println(resultado);
    }

}
