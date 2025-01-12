package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JogoTest {

    @Test
    public void testEmbaralhadorAleatorio() {
        Embaralhador embaralhador = new EmbaralhadorAleatorio();
        String palavra = "teste";
        String palavraEmbaralhada = embaralhador.embaralhar(palavra);

        // Garantir que a palavra embaralhada é diferente da original
        assertNotEquals(palavra, palavraEmbaralhada, "A palavra embaralhada não deve ser igual à original.");

        // Garantir que a palavra embaralhada tem os mesmos caracteres que a original
        char[] originalChars = palavra.toCharArray();
        char[] shuffledChars = palavraEmbaralhada.toCharArray();
        Arrays.sort(originalChars);
        Arrays.sort(shuffledChars);
        assertArrayEquals(originalChars, shuffledChars, "A palavra embaralhada deve conter os mesmos caracteres da original.");
    }

    @Test
    public void testBancoDePalavras() throws IOException {
        // Criar uma instância do BancoDePalavras com palavras simuladas
        List<String> palavrasSimuladas = Arrays.asList("banana", "carro", "computador", "cachorro");
        BancoDePalavras banco = new BancoDePalavras("palavras.txt.txt");

        // Garantir que as palavras são retornadas corretamente
        String palavra = banco.getPalavraAleatoria();
        assertTrue(palavrasSimuladas.contains(palavra), "A palavra retornada deve estar na lista original.");
    }

    @Test
    public void testMecanicaSimples() {
        MecanicaDoJogo mecanica = new MecanicaSimples();

        // Testar a lógica do jogo
        String palavraOriginal = "banana";
        String tentativaCorreta = "banana";
        String tentativaErrada = "maçã";

        assertTrue(mecanica.jogar(palavraOriginal, tentativaCorreta), "Deve retornar verdadeiro para tentativas corretas.");
        assertFalse(mecanica.jogar(palavraOriginal, tentativaErrada), "Deve retornar falso para tentativas erradas.");

        // Testar se o jogo termina corretamente
        for (int i = 0; i < 10; i++) {
            mecanica.jogar("palavra", "palavra"); // Simular 10 tentativas corretas
        }
        assertTrue(mecanica.acabou(), "O jogo deve terminar após 10 tentativas.");
    }
}
