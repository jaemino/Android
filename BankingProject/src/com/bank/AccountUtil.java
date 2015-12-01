package com.bank;

import java.util.ArrayList;

public class AccountUtil {
	ArrayList<Account> accountArray = null;
	
	public AccountUtil(){
		accountArray = new ArrayList<Account>();
	}

	public int newAccount(String name){
		int x = -1;
		boolean result = accountArray.add(new Account(name));
		if(result){
			x=1;
		}
		return x;
	}
	
	public void deposit(String name, int amount){
		for(int i=0; i<accountArray.size();i++){
			accountArray.get(i).setJangum(accountArray.get(i).getJangum() + amount);
		}
	}
	
	public int withdraw(String name, int amount){
		int x=-1;
		for(int i=0; i<accountArray.size();i++){
			if(accountArray.get(i).getName().equals(name)){
				if(accountArray.get(i).getJangum() >= amount){
					accountArray.get(i).setJangum(accountArray.get(i).getJangum() - amount/2);
					x=1;
				}
			}
		}
		return x;
	}
	
	public int confirm(String name){
		int x = 0;
		for (int i=0; i<accountArray.size();i++){
			if(accountArray.get(i).getName().equals(name)){
				x = accountArray.get(i).getJangum();
			}
		}
		return x;
	}
	
	public String getNames(){
		String names = "";
		
		for(int i=0; i<accountArray.size(); i++){
			if (i == accountArray.size() - 1){
				names +=accountArray.get(i).getName();
			} else{
				names +=accountArray.get(i).getName() + ",";
			}
		}
		return names;
	}
}
