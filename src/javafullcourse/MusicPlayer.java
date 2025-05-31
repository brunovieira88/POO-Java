package javafullcourse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicPlayer {
    public static void main(String[] args) {
        String filePath, userChoice;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name (.AIFF, .AU and .WAV): ");
        filePath = scanner.next();
        File audioFile = new File(filePath);
        try(AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            do {
                System.out.println("P: Play");
                System.out.println("S: Stop");
                System.out.println("R: Restart");
                System.out.println("Q: Quit");
                System.out.print("Enter your choise: ");
                userChoice = scanner.next();
                switch (userChoice.toUpperCase()) {
                    case "P":
                        clip.start();
                        break;
                    case "S":
                        clip.stop();
                        break;
                    case "R":
                        clip.setMicrosecondPosition(0);
                        break;
                    case "Q":
                        clip.close();
                        break;
                    default:
                        System.out.println("opcao invalida");
                }
                
            } while (!userChoice.toLowerCase().equals("q"));

        }catch(FileNotFoundException e){
            System.out.println("ficheiro nao existe");
        }catch (UnsupportedAudioFileException e) {
            System.out.println("ficheiro de audio nao esta no formato correto");
        }catch (IOException e) {
            System.out.println("algo nao funcionou corretamente ");
        }catch(LineUnavailableException e){
            System.out.println("nao foi possivel acessar o audio");
        }
        finally {
            System.out.println("programa terminado");
        }
        scanner.close();
    }
}
