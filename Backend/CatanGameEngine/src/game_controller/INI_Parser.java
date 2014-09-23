package game_controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class INI_Parser {
	
	ArrayList<section> sections = new ArrayList<section>();
	String ini_name;
	
	public INI_Parser(){
		
	}
	
	/**
	 * prints ini file to console
	 */
	public void print(){
		for(section s : sections)
			s.print();
	}
	
	/**
	 * Loads INI file into sections
	 * @param ini_name - path to ini file
	 */
	public boolean loadINI(String ini_name){
		clear();
		this.ini_name = ini_name;
		try{
			BufferedReader br = new BufferedReader(new FileReader(ini_name));
			String line = "";
			while((line = br.readLine()) != null){
				line = line.trim();
				if(line.length() > 2){
					if((line.charAt(0) == '[') && (line.charAt(line.length()-1) == ']')){
						line = line.substring(1, line.length()-1);
						sections.add(new section(line));
					} else{
						if(sections.size() == 0){
							System.out.println("[ERROR] cantrip.ini_parser.INI_Parser.loadINI error :: attempted to load a key-value pair without any sections");
							br.close();
							return false;
						}
						int index = -1;
						for(int ii = 0; ii < line.length(); ii++)
							if(line.charAt(ii) == '='){
								index = ii;
								break;
							}
						if(index == -1){
							System.out.println("[ERROR] cantrip.ini_parser.INI_Parser.loadINI error :: key-value pair not split by = sign");
							br.close();
							return false;
						}
						String key_name = line.substring(0, index);
						String value_name = line.substring(index+1);
						sections.get(sections.size()-1).addKey(key_name, value_name);
					}
				}
			}
			print();
			br.close();
		} catch(IOException e){
			System.out.println("[ERROR] cantrip.ini_parser.INI_Parser.loadINI error :: There was an IOException when trying to load INI file " + ini_name);
			return false;
		}
		return true;
	}
	
	public void writeINI(String new_ini_filename){
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(new_ini_filename, false));
			for(section s : sections)
				bw.write(s.toString());
			bw.close();			
		} catch(IOException e){
			System.out.println("[ERROR] cantrip.ini_parser.INI_Parser.writeINI error :: There was an IOException when trying to write INI file " + new_ini_filename);
		}
	}
	
	/**
	 * Sets a key <k> in section <s> to value <v> if it exists.
	 * @param s - name of section
	 * @param k - name of key
	 * @param v - name of value
	 */
	public boolean setKey(String s, String k, String v){
		section ss = findSection(s);
		if(ss == null)
			return false;
		return ss.setKey(k, v);
	}
	
	/**
	 * Sets all keys that match <k>, regardless of section, to value <v>
	 * @param k - name of key
	 * @param v - name of value
	 */
	public boolean setKey(String k, String v){
		boolean key_set = false;
		for(section ss : sections){
			if(ss.setKey(k,v))
				key_set = true;
		}
		return key_set;
	}
	
	/**
	 * Sets the name of section <old_sec> to <new_sec> if it exists
	 * @param old_sec - old section name
	 * @param new_sec - new section name
	 * @return true if success, false otherwise
	 */
	public boolean setSection(String old_sec, String new_sec){
		section ss = findSection(old_sec);
		if(ss == null)
			return false;
		ss.section_name = new_sec;
		return true;
	}
	
	/**
	 * Adds a key <k>, to section <s>, with value <v> if the section exists. If the key already exists, the value is updated
	 * @param s - name of section
	 * @param k - name of key
	 * @param v - name of value
	 */
	public boolean addKey(String s, String k, String v){
		section ss = findSection(s);
		if(ss == null)
			return false;
		ss.addKey(k, v);
		return true;
	}
	
	/**
	 * Adds key <k> with value <v> to all sections, or updates the key if it already exists
	 * @param k - name of key
	 * @param v - value of key
	 * @return true if success, false otherwise
	 */
	public boolean addKey(String k, String v){
		if(sections.size() == 0)
			return false;
		for(section ss : sections)
			ss.addKey(k, v);
		return true;
	}
	
	/**
	 * Adds a new section <s>
	 * @param s - name of section
	 */
	public void addSection(String s){
		if(findSection(s) == null)
			sections.add(new section(s));
	}
	
	/**
	 * Checks if a section exists
	 * @return true if section exists, false otherwise
	 */
	public boolean sectionsExist(){
		if(sections.size() > 0)
			return true;
		return false;
	}
	
	/**
	 * Returns a string array of all the section names
	 * @return - string array of section names
	 */
	public String[] getSectionNames(){
		String[] arr = new String[sections.size()];
		for(int ii = 0; ii < sections.size(); ii++)
			arr[ii] = sections.get(ii).section_name;
		return arr;
	}
	
	/**
	 * Gets all key names in a section, if it exists
	 * @param s - name of section
	 * @return String array of section key names, or null if section does not exist
	 */
	public String[] getSectionKeys(String s){
		section ss = findSection(s);
		if(ss == null)
			return null;
		return ss.getAllKeyNames();
	}

	/**
	 * Gets all key values in a section, if it exists
	 * @param s - name of section
	 * @return String array of section key values, or null if section does not exist
	 */
	public String[] getSectionValues(String s){
		section ss = findSection(s);
		if(ss == null)
			return null;
		return ss.getAllKeyValues();		
	}
	
	/**
	 * Gets the value of a key in a section if both the key and the section exist
	 * @param s - name of section
	 * @param k - name of key
	 * @return - value of key, or null if the section or the key do not exist
	 */
	public String getKey(String s, String k){
		section ss = findSection(s);
		if(ss == null)
			return null;
		key kk =  ss.getKey(k);		
		return kk.value;
	}
	
	private section findSection(String s){
		for(section ss : sections){
			if(ss.section_name.equals(s))
				return ss;
		}
		return null;
	}
	
	private void clear(){
		sections.clear();
	}
}

class section{
	public String section_name;
	ArrayList<key> keys = new ArrayList<key>();
	public section(String section_name){
		this.section_name = section_name;
	}
	
	/**
	 * Adds a key to the section if it doesn't exist. If it does exist, the key is updated.
	 * @param key_name - name of key to add
	 * @param key_value - value of key to add
	 */
	public void addKey(String key_name, String key_value){
		if(getKey(key_name) != null)
			setKey(key_name, key_value);
		keys.add(new key(key_name, key_value));
	}
	
	public key getKey(String key_name){
		for( key k : keys){
			if(k.keyMatch(key_name))
				return k;
		}
		return null;
	}
	
	public boolean deleteKey(String key_name){
		for(int ii = 0; ii < keys.size(); ii++)
			if(keys.get(ii).keyMatch(key_name)){
				keys.remove(ii);
				return true;
			}
		return false;
	}
	
	public boolean setKey(String key_name, String key_value){
		for(int ii = 0; ii < keys.size(); ii++)
			if(keys.get(ii).keyMatch(key_name)){
				keys.get(ii).setValue(key_value);
				return true;
			}
		return false;
	}
	
	public String[] getAllKeyNames(){
		String[] names = new String[keys.size()];
		int ii = 0;
		for(key k : keys){
			names[ii++] = k.getKeyName();
		}
		return names;
	}
	
	public String[] getAllKeyValues(){
		String[] values = new String[keys.size()];
		int ii = 0;
		for(key k : keys){
			values[ii++] = k.getValue();
		}
		return values;
	}
	
	public void print(){
		System.out.println("[" + section_name + "]");
		for(key k : keys){
			System.out.println(k.toString());
		}
	}
	
	public String toString(){
		String str = ("[" + section_name + "]\n");
		for(key k : keys)
			str += k.toString() + "\n";
		return str;
	}
	
	public boolean keyExists(String k){
		if(getKey(k) != null)
			return true;
		return false;
	}
	
}

class key{
	String key_name, value;
	public key(String key_name, String value){
		this.key_name = key_name;
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
	
	public String getKeyName(){
		return key_name;
	}
	
	public void setValue(String value){
		this.value = value;
	}
	
	public boolean keyMatch(String key_name){
		if(this.key_name.equals(key_name))
			return true;
		return false;
	}
	
	public String toString(){
		String str = key_name;
		str += "=";
		str += value;
		return str;
	}
}