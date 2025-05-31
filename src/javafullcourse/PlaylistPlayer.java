package javafullcourse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.sound.sampled.*;

public class PlaylistPlayer {
    private static List<File> musicFiles = new ArrayList<>();
    private static int currentIndex = 0;
    private static Clip clip;
    private static AudioInputStream audioStream;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir ao usuário o caminho da pasta de músicas
        System.out.print("Digite o caminho da pasta com músicas (.wav): ");
        String folderPath = scanner.nextLine();
        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) {
            scanner.close();
            throw new IllegalArgumentException("Pasta inválida.");
        }

        // Carregar todos os arquivos .wav na pasta
        for (File file : folder.listFiles()) {
            if (file.getName().toLowerCase().endsWith(".wav")) {
                musicFiles.add(file);
            }
        }

        if (musicFiles.isEmpty()) {
            scanner.close();
            throw new IllegalArgumentException("Nenhum arquivo válido encontrado.");
        }

        System.out.println("Músicas carregadas: " + musicFiles.size());
        playMusic(currentIndex);

        String userChoice;
        do {
            System.out.println("\nComandos:");
            System.out.println("P: Play");
            System.out.println("S: Stop");
            System.out.println("R: Restart");
            System.out.println("N: Next (Próxima música)");
            System.out.println("B: Back (Música anterior)");
            System.out.println("Q: Quit");
            System.out.print("Escolha uma opção: ");
            userChoice = scanner.next().toUpperCase();

            switch (userChoice) {
                case "P":
                    if (clip != null && !clip.isRunning()) {
                        clip.start();
                    }
                    break;
                case "S":
                    if (clip != null && clip.isRunning()) {
                        clip.stop();
                    }
                    break;
                case "R":
                    if (clip != null) {
                        clip.setMicrosecondPosition(0);
                        clip.start();
                    }
                    break;
                case "N":
                    nextMusic();
                    break;
                case "B":
                    previousMusic();
                    break;
                case "Q":
                    closeClip();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (!userChoice.equals("Q"));

        System.out.println("Reprodutor encerrado.");
        scanner.close();
    }

    private static void playMusic(int index) {
        if (index < 0 || index >= musicFiles.size()) {
            System.out.println("Índice de música inválido.");
            return;
        }

        closeClip(); 

        try {
            File musicFile = musicFiles.get(index);
            audioStream = AudioSystem.getAudioInputStream(musicFile);
            AudioFormat baseFormat = audioStream.getFormat();

            // Converte para PCM 16-bit se necessário
            AudioFormat decodedFormat = new AudioFormat(
                AudioFormat.Encoding.PCM_SIGNED,
                baseFormat.getSampleRate(),
                16,  
                baseFormat.getChannels(),
                baseFormat.getChannels() * 2,
                baseFormat.getSampleRate(),
                false
            );

            AudioInputStream convertedStream = AudioSystem.getAudioInputStream(decodedFormat, audioStream);

            clip = AudioSystem.getClip();
            clip.open(convertedStream); // Usa a versão convertida do áudio
            clip.start();
            System.out.println("Reproduzindo: " + musicFile.getName());
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Formato de áudio não suportado.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo de áudio.");
        } catch (LineUnavailableException e) {
            System.out.println("Erro ao acessar a linha de áudio.");
        }
    }

    private static void nextMusic() {
        if (currentIndex < musicFiles.size() - 1) {
            currentIndex++;
            playMusic(currentIndex);
        } else {
            System.out.println("Já está na última música.");
        }
    }

    private static void previousMusic() {
        if (currentIndex > 0) {
            currentIndex--;
            playMusic(currentIndex);
        } else {
            System.out.println("Já está na primeira música.");
        }
    }

    private static void closeClip() {
        if (clip != null) {
            clip.stop();
            clip.close();
            clip = null;
        }
        if (audioStream != null) {
            try {
                audioStream.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar o áudio.");
            }
        }
    }
}
