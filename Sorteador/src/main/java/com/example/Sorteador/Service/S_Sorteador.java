package com.example.Sorteador.Service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class S_Sorteador {
    public static int[] sortearNumeros(int quantity, int begin, int end) {
        int[] numerosSorteados = new int[quantity];
        Random random = new Random();

        for (int i = 0; i < quantity; i++) {
            numerosSorteados[i] = random.nextInt(end - begin + 1) + begin;
        }

        return numerosSorteados;
    }
    public static int[] sortearSemRepetition(int quantity, int begin, int end) {
        if (quantity > end) {
            throw new IllegalArgumentException("A quantidade de números a serem sorteados não pode ser maior que o limite.");
        }

        Set<Integer> numerosSorteados = new HashSet<>();
        Random random = new Random();

        while (numerosSorteados.size() < quantity) {
            int numeroSorteado = random.nextInt(end - begin + 1) + begin; // Gera um número aleatório entre 1 e o limite
            numerosSorteados.add(numeroSorteado);
        }

        // Converter o Set em um vetor
        int[] vetorNumbers = new int[quantity];
        int index = 0;
        for (int numero : numerosSorteados) {
            vetorNumbers[index++] = numero;
        }
        return vetorNumbers;
    }
    public static int[] ordemNumber(int[] numberOrdem) {
        return Arrays.stream(numberOrdem).sorted().toArray();
        }
    }