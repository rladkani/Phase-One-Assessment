package com.phaseone;

import java.util.*;
import java.io.*;
import java.text.Collator;

public class LockedMe {
	Scanner sc= new Scanner(System.in);
	public String message= "Welcome to Company Locker Pvt.Ltd\n";
	public String details = "Developed By - Richa Ladkani \nCompany - TekSystems Global Services Pvt. Ltd.";
	
	protected void add()
	{
	try{	
		Scanner sc= new Scanner(System.in);
	
	String s;
	s= sc.nextLine();
	File f2 = new File("C:\\Users\\rladkani\\Phase One _ rladkani");
	File f1= new File("C:\\Users\\rladkani\\Phase One _ rladkani\\"+s);
	String[] flist = f2.list(); 
	int flag=0;
  	
     for (int i = 0; i < flist.length; i++)
     {
    	 if(flist[i].equalsIgnoreCase(s))
    		 		flag=1;
     }
     if(flag==0)
     {	f1.createNewFile();
    	 System.out.println("File "+s+" added to the directory");
    	 System.out.println("\n");
     }
     else 
     {
    	 System.out.println(s+" already exists");
     }
    	
	}	catch(IOException e)
	{System.out.println(e.getMessage());
	}
}
	
	protected void delete()
	{try {
		String s1;
		s1=sc.next();
		File f2 = new File("C:\\Users\\rladkani\\Phase One _ rladkani\\"+s1);
			if(f2.exists())
			{	
				if(f2.delete())
				System.out.println("File deleted from the directory");
				System.out.println("\n");
			}
			else
			{
				System.out.println("File Not Found");
				System.out.println("\n");
			}
	}
	catch(Exception ex)
	{System.out.println(ex.getMessage());
	}
	}
	
	protected void search()
	{int flag=0;
		try {
		String search= sc.next();
		File file = new File("C:\\Users\\rladkani\\Phase One _ rladkani");  
		  String[] flist = file.list(); 
		  File file1= new File("C:\\Users\\rladkani\\Phase One _ rladkani\\"+search);
		  	
		         for (int i = 0; i < flist.length; i++)
		            {
		               if(flist[i].equals(search))
		               {
		               flag=1;
		               }
		              
		            } 
		         if(flag==0)
		         {
		        	 System.out.println(search+" not found");
		        	 
		         }
		         else 
		         {
		        	 System.out.println(search+" found at "+file1.getAbsolutePath());
		        	 System.out.print("\n");
		         }
		        	 
	}catch (Exception e)
	{System.out.println(e.getMessage());}
		                

	}
protected void	sorting()
{
	File f1 = new File("C:\\Users\\rladkani\\Phase One _ rladkani");
	 String[] f = f1.list(); 
	 Arrays.sort(f, Collator.getInstance());
	 System.out.println("---------------------------------------");
     System.out.println("Sorting by filename in ascending order ");
     System.out.println(Arrays.toString(f));
     System.out.println("---------------------------------------");
     /*if(f1.isDirectory())
		{
		List<String> l = Arrays.asList(f1.list());
				
		Collections.sort(l);
		System.out.println("---------------------------------------");
		System.out.println("Sorting by filename in ascending order");
			for(String s:l)
			{
				System.out.println(s);
			}
		System.out.println("---------------------------------------");
		}*/
	}

public void maincontext()
{
	System.out.println("MAIN CONTEXT");
	
	System.out.println("***************************************************************************");
	
	System.out.println("A: Retrieving file names in ascending order");
	
	System.out.println("B: Business Level Operations");
	
	System.out.println("C: Close the Application");

	System.out.println("***************************************************************************");
	
	System.out.println("\n");

	System.out.println("***************************************************************************");
	System.out.println("Enter an option");
	System.out.println("***************************************************************************");
}
public void businesscontext()
{

	System.out.println("Press 1 to Add file in the existing directory followed with extension if any ");
	System.out.println("Press 2 to Delete file in the existing directory");
	System.out.println("Press 3 to Search a file from directory");
	System.out.println("Press 4 for main context");
	System.out.println("\n");
}
	
	public void show()
	{
		char option;
		char ch;
		try {
		do 
		{	maincontext();
			option = sc.next().charAt(0);
			System.out.println("\n");
			inner:
			switch(option)
			{
			//case 'A'| 'a':
			case 'A' :
			case 'a':
				{
				sorting();
				//collator.getInstance
				}break;
				
				
			case 'B':
			case 'b':
				{	System.out.println("-----------------------------------------");
					
				do {
						businesscontext();
						ch=sc.next().charAt(0);
					
					switch(ch)
					{
						case '1':
							{
								System.out.println("Enter the name of the file you want to add ");
								System.out.println("\n");
								add();
							}break ;
							
						case '2':
							{
								System.out.println("Enter correct name of the file you want to delete ");
								System.out.println("\n");
								delete();
							}
							break;
						case '3':
							
							{
								System.out.println("Enter the name of the file you want to search ");
								System.out.println("\n");
								search();
							}break ;
							
						case '4':
							break inner;
						default:
							{
								System.out.println("Invalid Input");
								System.out.println("\n");
							}break ;
						}
										
					}while(ch!=(4));
				}
				break;
					
			case 'C':
			case 'c':
				{
					System.exit(0);
				}
			break;
			
			default:
				System.out.println("Invalid Input");
				}

		}while(option!=('c'|'C'));
	
	}
	catch (Exception e)
	{
		System.out.print(e.getMessage());
		
	}
}
	public static void main(String[] args) 
	{
		
		LockedMe locker = new LockedMe();
		System.out.println(locker.message);
		System.out.println(locker.details);
		System.out.println("\n");
		
		locker.show();
			
		System.out.println("\n");
		
		
	}
}

