package com.tsop.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListFileRead {
/*	
public static void main(String[] args){
	
		ListFileRead lfr=new ListFileRead();
		
		try{
		lfr.writePlaylistFile(1, 1, "audios/Bridges.mp3");
		lfr.writePlaylistFile(1, 2, "audios/Lone_Wolf.mp3");
		lfr.writePlaylistFile(1, 3, "audios/Bridges.mp3");
		lfr.writePlaylistFile(1, 4, "audios/Lone_Wolf.mp3");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}*/

	public List<String> readPlaylistFile(int playlistId) throws IOException{
		
		List<String> list = new ArrayList<String>();

		File file=new File("C:\\j2ee_works\\TSOP\\playlist\\"+playlistId+".tsop");
		
		if(!file.exists())
			{
				return null;
			}
		
		FileReader fr=null;
		BufferedReader br=null;
		
		try{
			
			fr=new FileReader(file);
			System.out.println("a");
			br=new BufferedReader(fr);
			System.out.println("b");
			
			while(true)
			{	String str=br.readLine();
				System.out.println(str);
				if(str==null)
					break;
				list.add(str);
				
			}
		}
		catch(EOFException e){
			e.printStackTrace();
			return list; 
		}
		finally{
			
			 if (br != null)
				  br.close();
			 if (fr != null)
			  fr.close();
			 
			 
		}
		
		return list;
		
	}

	public String writePlaylistFile(int playlistId, int musicId, String musicPath) throws IOException {
		
		File dirfile=new File("C:\\j2ee_works\\TSOP\\playlist");
		File file=new File("C:\\j2ee_works\\TSOP\\playlist\\"+playlistId+".tsop");
		
		if(!dirfile.exists())
			dirfile.mkdirs();
			
		if(!file.exists())
			{
				file.createNewFile();
			}
		
		FileWriter fw=new FileWriter(file,true);
		
		fw.write(musicId+"-"+musicPath+"\r\n");
		
		fw.flush();
		fw.close();
		
		return null;
	}

}
