package br.com.ocrteste.pablo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class PabloApplication {
	public static void main(String[] args) {
		File imageFile = new File("/home/pablosouza/Documentos/entrada_file/teste.jpg");

		// Configurar o objeto Tesseract
		ITesseract instance = new Tesseract();
		instance.setDatapath("/usr/share/tesseract/tessdata"); // Caminho correto para a pasta com os dados do Tesseract
		instance.setLanguage("por"); // Substitua pelo idioma correto

		try {
			// Carregar a imagem
			instance.setTessVariable("user_defined_dpi", "300"); // Definir a resolução da imagem
			String result = instance.doOCR(imageFile);

			// Caminho para o arquivo onde você deseja salvar o texto extraído
			String outputPath = "/home/pablosouza/Documentos/entrada_file/texto_extraido.txt"; // Caminho correto para o arquivo de saída

			// Salvar o texto extraído em um arquivo
			saveTextToFile(result, outputPath);

			System.out.println("Texto extraído salvo com sucesso.");
		} catch (TesseractException e) {
			System.err.println(e.getMessage());
		}
	}

	public static void saveTextToFile(String text, String outputPath) {
		// ... (mesmo código para salvar o texto em um arquivo)
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write(text);
            System.out.println("Texto salvo com sucesso em: " + outputPath);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o texto em arquivo: " + e.getMessage());
        }
	}
}
