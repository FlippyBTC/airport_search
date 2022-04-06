package csv;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Airport {


	public static void main(String[] args) throws FileNotFoundException {

		if (args.length == 0) {
			System.out.println("Введите номер столбца в параметры программы");
			return;
		}

		int columnNumber = readColumnNumber(args[0]);

		if (!isCorrectColumnNumber(columnNumber)) {
			System.out.println("Значение столбцов должно быть от 0 до 13");
			return;
		}

		String findText = readFindText();

		long timeStart = System.currentTimeMillis();
		List<String> lines = SearchService.searchFile(columnNumber, findText);

		int count = SearchService.getCount(lines);
		long timeEnd = System.currentTimeMillis();


		System.out.println(count);
		System.out.println(String.join("\n", lines));
		System.out.println(timeEnd - timeStart + "мс");


	}

	public static String readFindText() {
		Scanner scanner = new Scanner(System.in);

		String findText;
		System.out.println("Введите значение для поиска: ");
		while ((findText=scanner.nextLine()).isEmpty()) {
			System.out.println("Введите значение для поиска: ");


		}

		return findText;
	}

	public static int readColumnNumber(String arg) {
		return Integer.parseInt(arg);
	}

	public static boolean isCorrectColumnNumber(int columnNumber) {
		return columnNumber <= 13 && columnNumber >= 0;
	}


}
