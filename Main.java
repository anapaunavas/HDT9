// Ana Paula Hong 22731

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

// A modifier that allows the class to be accessed by other classes.
public class Main {
    private static BinarySearchTree<String, String> englishSpanishDictionary = new BinarySearchTree<String,String>(new compareStrings<String>());
	private static BinarySearchTree<String, String> frenchSpanishDictionary = new BinarySearchTree<String,String>(new compareStrings<String>());

    
    /** 
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Bienvenidx al diccionario traductor :) ");
		start();
    }

    
    /** 
     * @throws IOException
     * @throws InterruptedException
     */
    private static void start()throws IOException, InterruptedException {
		int selection = 0;
		
		ArrayList<ArrayList<String>> wordsDictionary = extracting_data();
		
		for(int i = 0; i < wordsDictionary.size(); i++) {
			englishSpanishDictionary.insert(wordsDictionary.get(i).get(0), wordsDictionary.get(i).get(1));
        }
    }

    while(selection != 5) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        selection = OptionsMainMenu();
        switch(selection) {
            case 1:
                // agregar una nueva palabra al diccionario.
                typeDictionary(selection, englishSpanishDictionary, frenchSpanishDictionary);
                break;
            case 2:
                // eliminar una palabra del diccionario
                typeDictionary(selection, englishSpanishDictionary, frenchSpanishDictionary);
                break;
            case 3:
                // traduccion
                translateOptions(englishSpanishDictionary, frenchSpanishDictionary);
                break;
            case 4:
                // listado de palabras en ingles
                ITreeTraversal<String> englishValue = new ITreeTraversal<String>(){
                    @Override	
                    public void Walk(String value) {
                        System.out.println(value);
                    }
                };
                System.out.println("listado de palabras en ingles");
                englishSpanishDictionary.inOrder(englishValue);
                wait(3000);
                break;

            default:
                //End system.
                System.out.println("gracias por utilizar el diccionario :) ");
                break;
        }
    }

     /** 
     * @param englishSpanishDictionary
     * @param frenchSpanishDictionary
     * @throws IOException
     * @throws InterruptedException
     */
    private static void translateOptions(BinarySearchTree<String, String> englishSpanishDictionary) throws IOException, InterruptedException {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		int selection = translationOptions();
		switch(selection) {
			case 1:
				// traducir oracion en ingles
				translating(selection, englishSpanishDictionary);
				break;

			default:
				// end system
				start();
				break;
		}
	}

     /** 
     * @param selection
     * @param Dictionary
     */
    private static void translating(int selection, BinarySearchTree<String, String> Dictionary) {
		String word = " ";
		ArrayList<String> translated = new ArrayList<String>();
		switch(selection) {
			case 1:
				word = JOptionPane.showInputDialog("Ingrese una oracion en ingles para traducirla: ");
				break;
		}
		//word = word.replaceAll(",", " ");
		//word = word.replaceAll(".", " ");

        String[] words = word.split(" ");
		for(int i = 0; i < words.length; i++) {
			if(Dictionary.find(words[i]) == null) {
				translated.add("*" + words[i]+"*");
			}else {
				translated.add(Dictionary.find(words[i]));
			}
		}
		
		for(int i = 0; i < translated.size(); i++) {
			System.out.print(translated.get(i) + " ");
		}
		wait(3000);
		
	}
}