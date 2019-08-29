import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class anagramFinder{

	public static void main(String [] args) throws Exception{
		//Inputs
		//Test data
		List<string> list = new ArrayList<String>();
		list.add("eat");
		list.add("tea");
		list.add("tan");
		list.add("ate");
		list.add("nat");
		list.add("bat");
		
		System.out.println(findAnagrams(list));
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
	}
	
	private static Map <String, List<String>> findAnagrams (List<String> words){
		//Mapper
		Map<String,List<String>> anagrams - null;

		if(words == null || words.size() ==0){
		return null;
		}

		anagrams = new HashMap<String, List<String>>();

		//words are taken, stripped, sorted and put into an array
		for(String word : words){
			char [] charArray = word.trim().toCharArray();
			Arrays.sort(charArray);
			String sortedWord = String.valueOf(charArray);
			//output.collect(sortedWord, word);

				//reducer
				if (anagrams.containsKey(sortedWord)){
					List<String> newList = anagrams.get(sortedWord);
					newList.add(word);
					anagrams.put(sortedWord, newList)
				}
				else{
					List<String> list = new ArrayList<String>();
					list.add(word);
					anagrams.put(sortedWord, list);
				}
		}
		return anagrams;
	}
}