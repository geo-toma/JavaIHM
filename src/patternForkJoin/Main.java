package patternForkJoin;

import java.nio.file.Paths;
import java.util.concurrent.ForkJoinPool;

public class Main {

	public static void main(String[] args) {

		FolderScanner f = new FolderScanner();
		
		try {
			long start = System.currentTimeMillis();
			long result = f.sequantialScan(Paths.get("D:\\Semestre"), "*.pdf");
			long end = System.currentTimeMillis();
			System.out.println("il y a "+result+" fichiers portant l'extention .pdf");
			System.out.println("Temps de traitement = "+(end - start));
		} catch (ScanException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n\n\n");
		
		FolderScanner fs = new FolderScanner(Paths.get("D:\\Semestre"), "*.pdf");
		int processeurs = Runtime.getRuntime().availableProcessors();
		ForkJoinPool pool = new ForkJoinPool(processeurs);
		long start = System.currentTimeMillis();
		long resultat = /*fs.compute();*/pool.invoke(fs);
		long end = System.currentTimeMillis();
		System.out.println("il y a "+resultat+" fichiers portant l'extention .pdf");
		System.out.println("Temps de traitement = "+(end - start));

	}

}
