package patternForkJoin;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderScanner extends RecursiveTask<Long> {

	private static final long serialVersionUID = 1L;
	private Path path;
	private String filter = "*";
	private long result;
	
	public FolderScanner() {
	}
	
	
	public FolderScanner(Path path, String filter) {
		this.path = path;
		this.filter = filter;
		this.result = 0;
	}


	public long sequantialScan(Path path, String filter) throws ScanException {
		result = 0;
		if(path == null || path.toString().equals(""))
			throw new ScanException("Chemin a scanner non valide (vide ou nul)");
		
		try (DirectoryStream<Path> listing = Files.newDirectoryStream(path)){
			for(Path p : listing) {
				if(Files.isDirectory(p.toAbsolutePath()))
					result += sequantialScan(p, filter);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(DirectoryStream<Path> listing = Files.newDirectoryStream(path, filter)){
			for(Path p : listing) {
				System.out.println(p.toAbsolutePath());
				result++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public long paralleleScan() throws ScanException {
		List<FolderScanner> list = new ArrayList<>();
		if(path == null || path.toString().equals(""))
			throw new ScanException("Chemin a scanner non valide (vide ou nul)");
		
		try (DirectoryStream<Path> listing = Files.newDirectoryStream(path)){
			for(Path p : listing) {
				if(Files.isDirectory(p.toAbsolutePath())) {
					FolderScanner f = new FolderScanner(p, filter);
					list.add(f);
					f.fork();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(DirectoryStream<Path> listing = Files.newDirectoryStream(path, filter)){
			for(Path p : listing) {
				System.out.println(p.toAbsolutePath());
				result++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(FolderScanner f : list)
			result += f.join();
		
		return result;
	}

	@Override
	protected Long compute() {
		long result = 0;
		try {
			result = paralleleScan();
		} catch (ScanException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	

}
