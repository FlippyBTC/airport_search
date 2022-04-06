package csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SearchService {
	private static final String fileName = "airports.csv";

	private static List<String> readAllLines(){
		try {
			return Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			System.out.println("Файл не найден");
		}
		return null;
	}
	private static List<String> search(List<String> lines, int columnNumber,String findText){
		return lines.parallelStream()
				.filter(n -> n.split(",")[columnNumber].contains(findText))
				.sorted((o1, o2) -> o1.split(",")[columnNumber].compareTo(o2.split(",")[columnNumber]))
				.collect(Collectors.toList());
	}
	public static int getCount(List<String> lines){
		return lines.size();
	}
	public static List<String> searchFile(int columnNumber,String findText){
		List<String> allLines = readAllLines();
		List<String> result = search(allLines,columnNumber,findText);
		return result;
	}

}
