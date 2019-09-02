package sql1;

import java.io.*;
import java.lang.*;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import java.sql.*;
class state 
{
	   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/first";

	   static final String USER = "root";
	   static final String PASS = "mnbv";
	public static void main(String args[]) throws IOException
	{
		 Connection conn = null,conn2=null;
	       Statement stmt = null,stmt2=null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.cj.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      /////////
	      System.out.println("Inserting records into the table...");
	      //stmt = conn.createStatement();
	      //String delete = "delete from election2019";
    	  //stmt.executeUpdate(delete);
		int no_of_cons[]={25,2,14,40,2,26,10,4,6,28,20,29,48,2,2,1,1,21,13,25,1,29,2,80,42,11,14,5,17};
		String name_of_state[]={"Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Goa","Gujrat","Harayana","Himachal Pradesh","Jammu and Kashmir","Karnataka","Kerala","Madhya Pradesh","Maharastra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Tripura","Uttar Pradesh","West Bengal","Chhattisgarh","Jharkhand","Uttarakhand","Telangana"};
		/*int statecode,con_code,i1=0,j1,k1;
		String constituencyname = null;
		for(statecode = 1;statecode <= 29;statecode++)
		{
			System.out.println(name_of_state[statecode-1]);
			
			for(con_code=1;con_code<=no_of_cons[statecode-1];con_code++)
			{
			    if(statecode>=10){
                Document doc=Jsoup.connect("http://results.eci.gov.in/pc/en/constituencywise/ConstituencywiseS"+statecode+con_code+".htm?ac="+con_code).get();
			    Elements lis=doc.select("a[href]");
			    
			    for (Element row : doc.select("table.tabc tr"))
		        {
			    	
			    	
		                if (row.select("td:nth-of-type(1)").text().equals("")) {
		                	//System.out.println(row.select("td:nth-of-type(1)").text());
		                    continue;
		                }
		                else {
		                	
		                	i1++;
		                   String statename=name_of_state[statecode-1];
		                   String serial_no = row.select("td:nth-of-type(1)").text();
		                   String can_name1=row.select("td:nth-of-type(2)").text();
		                   String party1=row.select("td:nth-of-type(3)").text();
		                   String won=row.select("td:nth-of-type(4)").text();
		                   String vote=row.select("td:nth-of-type(6)").text();
		                   String per_of_vote1=row.select("td:nth-of-type(7)").text();
		                   
		                   int nvote=changefromstringtoint(vote);
		                   float per_of_vote=changefromstringtofloat(per_of_vote1);
		                   if(i1==12)
		                   {
		                	   
		                	   String removeFromThisPart = "Result";

		                	   serial_no = serial_no .substring(0, serial_no .lastIndexOf( removeFromThisPart ));
		                	   constituencyname=serial_no;
		                	   //System.out.println(serial_no);
		                   }
		                   if(i1>12)
		                   {
		                	   String can_name=apostrophe(can_name1);
		                	   String party=apostrophe(party1);
		                	   //System.out.println(constituencyname+" "+can_name+" "+party+" "+won+" "+nvote+" "+per_of_vote+" "+statecode+" "+i1);
		                	   stmt = conn.createStatement();
		        			   String sql;
		        			   //sql="insert into election2019 values('man','"+can_name+"','"+party+"','"+nvote+"','0.82')";
		        	         sql="insert into election2019 values('"+statename+"','"+constituencyname+"','"+can_name+"','"+party+"','"+nvote+"', '"+per_of_vote+"')";
		        	         stmt.executeUpdate(sql); 
		                    
		                   }
		                   if(can_name1.equals("NOTA"))
		                   break;
		                }
		        }
			    i1=0;
			    }//closing of if(i>9)
			    else if(statecode==9)//jammu and kashmir
			    {
			    	Document doc=Jsoup.connect("http://results.eci.gov.in/pc/en/constituencywise/ConstituencywiseS0"+statecode+con_code+".htm?ac="+con_code).get();
				    Elements lis=doc.select("a[href]");
				    
				    for (Element row : doc.select("table.tabc tr"))
			        {
				    	
				    	
			                if (row.select("td:nth-of-type(1)").text().equals("")) {
			                	//System.out.println(row.select("td:nth-of-type(1)").text());
			                    continue;
			                }
			                else {
			                	
			                	i1++;
			                	String statename=name_of_state[statecode-1];
			                   String serial_no = row.select("td:nth-of-type(1)").text();
			                   String can_name1=row.select("td:nth-of-type(2)").text();
			                   String party1=row.select("td:nth-of-type(3)").text();
			                   String won=row.select("td:nth-of-type(4)").text();
			                   String vote=row.select("td:nth-of-type(7)").text();
			                   String per_of_vote1=row.select("td:nth-of-type(8)").text();
			                
			                   int nvote=changefromstringtoint(vote);
			                   float per_of_vote=changefromstringtofloat(per_of_vote1);
			                   if(i1==12)
			                   {
			                	   
			                	   String removeFromThisPart = "Result";

			                	   serial_no = serial_no .substring(0, serial_no .lastIndexOf( removeFromThisPart ));
			                	   constituencyname=serial_no;
			                	   //System.out.println(serial_no);
			                   }
			                   if(i1>12)
			                   {
			                	   String can_name=apostrophe(can_name1);
			                	   String party=apostrophe(party1);
			                	   //System.out.println(constituencyname+" "+can_name+" "+party+" "+won+" "+nvote+" "+per_of_vote+" "+statecode+" "+i1);
			                	   stmt = conn.createStatement();
			        			   String sql;
			        			   //sql="insert into election2019 values('man','"+can_name+"','"+party+"','"+nvote+"','0.82')";
			        	         sql="insert into election2019 values('"+statename+"','"+constituencyname+"','"+can_name+"','"+party+"','"+nvote+"', '"+per_of_vote+"')";
			        	         stmt.executeUpdate(sql); 
			                    
			                   }
			                   if(can_name1.equals("NOTA"))
			                   break;
			                }
			        }
				    i1=0;
				    }
			    
			    else
			    {
			    	Document doc=Jsoup.connect("http://results.eci.gov.in/pc/en/constituencywise/ConstituencywiseS0"+statecode+con_code+".htm?ac="+con_code).get();
				    Elements lis=doc.select("a[href]");
				    //System.out.println(i+"asedrft"+doc.title());
				    for (Element row : doc.select("table.tabc tr"))
			        {
				    	
			                if (row.select("td:nth-of-type(1)").text().equals("")) {
			                	//System.out.println(row.select("td:nth-of-type(1)").text());
			                    continue;
			                }
			                else {
			                	i1++;
			                   String statename=name_of_state[statecode-1];
			                   String serial_no = row.select("td:nth-of-type(1)").text();
			                   String can_name1=row.select("td:nth-of-type(2)").text();
			                   String party1=row.select("td:nth-of-type(3)").text();
			                   String won=row.select("td:nth-of-type(4)").text();
			                   String vote=row.select("td:nth-of-type(6)").text();
			                   String per_of_vote1=row.select("td:nth-of-type(7)").text();
			                   String removeFromThisPart=null;
			                   int nvote=changefromstringtoint(vote);
			                   float per_of_vote=changefromstringtofloat(per_of_vote1);
			                   if(i1==12)//for constituency name
			                   {
			                	   
			                	   removeFromThisPart = "Result";

			                	   serial_no = serial_no .substring(0, serial_no .lastIndexOf( removeFromThisPart ));
			                	   constituencyname=serial_no;
			                	   //System.out.println(constituencyname);
			                   }
			                   else if(i1>12)			                	   
			                   {
			                	   String can_name=apostrophe(can_name1);
			                	   String party=apostrophe(party1);
			                	   //System.out.println(constituencyname+" "+can_name+" "+party+" "+won+" "+nvote+" "+per_of_vote+" "+statecode+" "+i1);
			                	   stmt = conn.createStatement();
			        			   String sql;
			        			   //sql="insert into election2019 values('man','"+can_name+"','"+party+"','"+nvote+"','0.82')";
			        			   sql="insert into election2019 values('"+statename+"','"+constituencyname+"','"+can_name+"','"+party+"','"+nvote+"','"+per_of_vote+"')";
			        	           stmt.executeUpdate(sql);
			                  
			                   }
			                   if(can_name1.equals("NOTA"))
			                   break;
			                }
			        }
				    i1=0;
			    }
			}
		}//end of for loop statecode
		
		int uno_of_cons[]={1,1,1,1,7,1,1};
		String name_of_ut[]={"Andaman & Nicobar Islands","Chandigarh","Dadra & Nagar Haveli","Daman & Diu","Delhi","Lakshadweep","Puducherry"};
		int ut,con_codeut,i2=0;
		for(ut=1;ut<=7;ut++)
		{
			//System.out.println(name_of_ut[ut-1]);
			for(con_codeut=1;con_codeut<=uno_of_cons[ut-1];con_codeut++)
			{
                Document doc=Jsoup.connect("http://results.eci.gov.in/pc/en/constituencywise/ConstituencywiseU0"+ut+con_codeut+".htm?ac="+con_codeut).get();
			    Elements lis=doc.select("a[href]");
			    
			    for (Element row : doc.select("table.tabc tr"))
		        {
			    	
			    	
		                if (row.select("td:nth-of-type(1)").text().equals("")) {
		                	//System.out.println(row.select("td:nth-of-type(1)").text());
		                    continue;
		                }
		                else {
		                	
		                	i2++;
		                	String nameofut=name_of_ut[ut-1];
		                   String serial_no = row.select("td:nth-of-type(1)").text();
		                   String can_name1=row.select("td:nth-of-type(2)").text();
		                   String party1=row.select("td:nth-of-type(3)").text();
		                   String won=row.select("td:nth-of-type(4)").text();
		                   String vote=row.select("td:nth-of-type(6)").text();
		                   String per_of_vote1=row.select("td:nth-of-type(7)").text();
		                   int nvote=changefromstringtoint(vote);
		                   float per_of_vote=changefromstringtofloat(per_of_vote1);
		                   if(i2==12)
		                   {
		                	   
		                	   String removeFromThisPart = "Result";

		                	   serial_no = serial_no .substring(0, serial_no .lastIndexOf( removeFromThisPart ));
		                	   constituencyname=serial_no;
		                	   //System.out.println(constituencyname);
		                   }
		                   if(i2>12)
		                   {
		                	   String can_name=apostrophe(can_name1);
		                	   String party=apostrophe(party1);
		                     stmt = conn.createStatement();
		        			 String sql;
		        			 sql="insert into election2019 values('"+nameofut+"','"+constituencyname+"','"+can_name+"','"+party+"','"+nvote+"','0.82')";
		        			 //sql="insert into election2019 values('"+serial_no+"','"+can_name+"','"+party+"','"+nvote+"','"+per_of_vote+"')";
		        	         stmt.executeUpdate(sql);	   
		                   //System.out.println(constituencyname+" "+can_name+" "+party+" "+won+" "+nvote+" "+per_of_vote+" "+ut+" "+i2);
		                   }
		                   if(can_name1.equals("NOTA"))
		                   break;
		                }
		        }
			    i2=0;
			 }
		}//end of ut*/
		//MAXIMUM NUMBER OF VOTES
		System.out.println("WHO HAS GOT MAXIMUM NUMBER OF VOTES IN LOK SABHA ELEETION 2019");
		stmt2 = conn.createStatement();
		ResultSet rr;
        rr = stmt2.executeQuery("SELECT * FROM election2019 where no_of_votes=(select max(no_of_votes) from election2019);");
       
       while (rr.next()) {
          
          String party = rr.getString("party");
          String name = rr.getString("can_name");
          String conname = rr.getString("constituenc");
          int no11 = rr.getInt("no_of_votes");
          System.out.println(name+" from "+conname+" related to "+party+" who has got "+no11+" number of votes");
       }
       System.out.println();
       stmt2 = conn.createStatement();
       rr = stmt2.executeQuery("SELECT SUM(no_of_votes) FROM election2019;");
      while (rr.next()) {
        
         int no11 = rr.getInt("sum(no_of_votes)");
         System.out.println("TOTAL NUMBER OF VOTES  "+no11);
      }
      System.out.println();
      stmt2 = conn.createStatement();
      rr = stmt2.executeQuery("SELECT SUM(no_of_votes) FROM election2019 where party='Bharatiya Janata Party';");
     while (rr.next()) {
       
        int no11 = rr.getInt("sum(no_of_votes)");
        System.out.println("TOTAL NUMBER OF VOTES OF BJP(NOT NDA) "+no11);
     }
          System.out.println();
	      System.out.println("LIST OF CANDIDATES WHO HAS GOT MAXIMUM NUMBER OF VOTES OF THEIR STATE");
	      System.out.println();
	      stmt = conn.createStatement();
	      ResultSet rs,rp;
          rs = stmt.executeQuery("SELECT max(no_of_votes) from election2019 group by state; ");
          while ( rs.next() ) 
          {
              //String lastName = rs.getString("can_name");
        	  int noofvotes=rs.getInt("max(no_of_votes)");
        	  stmt2 = conn.createStatement();
               rp = stmt2.executeQuery("SELECT * FROM election2019 where no_of_votes="+noofvotes+";");
              
              while (rp.next()) {
                 
                 String party = rp.getString("party");
                 String name = rp.getString("can_name");
                 String conname = rp.getString("constituenc");
                 int no11 = rp.getInt("no_of_votes");
                 System.out.println(name+" from "+conname+" related to "+party+" who has got "+no11+" number of votes");
                 // System.out.println(state+" "+conname+"   "+name+"    "+no11);
              }
              
          }
          System.out.println(); System.out.println();
          System.out.println("TOP 10 LIST OF CANDIDATES WHO HAS GOT MAXIMUM NUMBER OF VOTES IN LOK SABHA ELECTION");
          System.out.println();
          stmt = conn.createStatement();
          rs = stmt.executeQuery("SELECT * from election2019 order by no_of_votes desc limit 10;");
          while ( rs.next() ) 
          {      
                 String party = rs.getString("party");
                 String name = rs.getString("can_name");
                 String conname = rs.getString("constituenc");
                 int no11 = rs.getInt("no_of_votes");
                 System.out.println("\n"+name+" from "+conname+" related to "+party+" who has got "+no11+" number of votes");
          }
          System.out.println(); System.out.println();
          System.out.println("TOP 10 LIST OF CANDIDATES WHO HAS GOT MINIMUM NUMBER OF VOTES IN LOK SABHA ELECTION");
          System.out.println();
          stmt = conn.createStatement();
          rs = stmt.executeQuery("SELECT * from election2019 order by no_of_votes limit 10;");
          while ( rs.next() ) 
          {      
                 String party = rs.getString("party");
                 String name = rs.getString("can_name");
                 String conname = rs.getString("constituenc");
                 int no11 = rs.getInt("no_of_votes");
                 System.out.println(name+" from "+conname+" related to "+party+" who has got "+no11+" number of votes");
          }
          System.out.println(); System.out.println();
          System.out.println("TOP 10 PLACES WHERE NOTA GOT MAXIMUM NUMBER OF VOTES IN LOK SABHA ELECTION");
          System.out.println();
          stmt = conn.createStatement();
          rs = stmt.executeQuery("SELECT * from election2019 WHERE can_name='NOTA' order by no_of_votes desc limit 10;");
          while ( rs.next() ) 
          {      
                 String party = rs.getString("party");
                 String name = rs.getString("can_name");
                 String conname = rs.getString("constituenc");
                 int no11 = rs.getInt("no_of_votes");
                 System.out.println(conname+" where NOTA has got "+no11+" number of votes");
          }
          System.out.println(); System.out.println();
          System.out.println("TOP 10 PLACES WHERE NOTA GOT MINIMUM NUMBER OF VOTES IN LOK SABHA ELECTION");
          System.out.println();
          stmt = conn.createStatement();
          rs = stmt.executeQuery("SELECT * from election2019 WHERE can_name='NOTA' order by no_of_votes limit 10;");
          while ( rs.next() ) 
          {      
                 String party = rs.getString("party");
                 String name = rs.getString("can_name");
                 String conname = rs.getString("constituenc");
                 int no11 = rs.getInt("no_of_votes");
                 System.out.println(conname+" where NOTA has got "+no11+" number of votes");
          }
          System.out.println(); System.out.println();
          System.out.println("TOP 10 LIST OF CANDIDATES WHO HAS GOT MINIMUM NUMBER OF PERCENT OF VOTES IN LOK SABHA ELECTION");
          System.out.println();
          stmt = conn.createStatement();
          rs = stmt.executeQuery("SELECT * from election2019 order by perofvote limit 10;");
          while ( rs.next() ) 
          {      
                 String party = rs.getString("party");
                 String name = rs.getString("can_name");
                 String conname = rs.getString("constituenc");
                 int no11 = rs.getInt("no_of_votes");
                 float percent=rs.getFloat("perofvote");
                 System.out.println(name+" from "+conname+" related to "+party+" who has got "+no11+" number of votes and "+percent+" percent of votes");
          }
          System.out.println(); System.out.println();
          System.out.println("TOP 10 LIST OF CANDIDATES WHO HAS GOT MAXIMUM NUMBER OF PERCENT OF VOTES IN LOK SABHA ELECTION");
          System.out.println();
          //System.out.println("TOP 10 PLACES WHERE NOTA GOT MAXIMUM NUMBER OF PERCENT OF VOTES IN LOK SABHA ELECTION");
          stmt = conn.createStatement();
          rs = stmt.executeQuery("SELECT * from election2019 order by perofvote DESC limit 10;");
          while ( rs.next() ) 
          {      
                 String party = rs.getString("party");
                 String name = rs.getString("can_name");
                 String conname = rs.getString("constituenc");
                 int no11 = rs.getInt("no_of_votes");
                 float percent=rs.getFloat("perofvote");
                 System.out.println(name+" from "+conname+" related to "+party+" who has got "+no11+" number of votes and "+percent+" percent of votes");
          }
          System.out.println("whole table");
          int count=0;
         stmt = conn.createStatement();
          rs = stmt.executeQuery("SELECT * from election2019;");
          while ( rs.next() ) 
          {      
                 String party = rs.getString("party");
                 String name = rs.getString("can_name");
                 String conname = rs.getString("constituenc");
                 int no11 = rs.getInt("no_of_votes");
                 float percent=rs.getFloat("perofvote");
                 count++;
                 //System.out.println(name+" from "+conname+" related to "+party+" who has got "+no11+" number of votes and "+percent+" percent of votes");
          }

          System.out.println("manish end "+count);
		 stmt.close();
	      conn.close();
	   }catch(Exception e){
		   
		   System.out.print("Exception occoured \n"+e.getMessage()+"\n");
	   }
	   finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	}
	static int changefromstringtoint(String str)
	{
		int result=0;
		for(int i=0;i<str.length();i++)
		{
			result=result+(((int)str.charAt(str.length()-i-1)-48)*(int)Math.pow(10, i));
		}
		//System.out.println(result);
		return result ;
	}
	static String apostrophe(String Str)
	{
		String result="";
		String specialCharacters="'";
		String s="'";
		 int index=1000;
		for (int i = 0; i < Str.length(); i++) {
			if (Str.contains(Character.toString(s.charAt(0)))&&i==Str.length()-1)
		    {
		        continue;
		    }
		    else if (specialCharacters.contains(Character.toString(Str.charAt(i))))
		    {
		       
		        //System.out.println(Str.charAt(i)+": is a special character"+i);
		       result=result+Str.charAt(i);
		       index=i+1;
		    }
		    else if(index==i)
		    {
		        result=result+specialCharacters+"s";
		    }
		    else if(Str.charAt(i)==',')
		    {
		        continue;
		    }
		    else
		    result=result+Str.charAt(i);
		  }
		 return result;
	}
	static float changefromstringtofloat(String str)
	{
		int result=0,point=0,flo=0;
		float ans,ans1;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='.'){
				point=i;break;}
		}
		//System.out.println("point"+point);
		
		for(int i=0;i<point;i++)
		{
			result=result+(((int)str.charAt(point-i-1)-48)*(int)Math.pow(10, i));
		}
		ans=(float)result;
		//System.out.println("result "+ans);
		if(point!=0)
		{
		for(int i=0;i<str.length()-point-1;i++)
		{
			flo=flo+(((int)str.charAt(str.length()-i-1)-48)*(int)Math.pow(10, i));
		}
		if(flo>9)
		ans1=(float)flo/100;
		else
		ans1=(float)flo/10;
		ans=ans+ans1;
		}
		else
		ans=changefromstringtoint(str);
		//System.out.println("result "+ans+"floatvalue "+flo);
		return ans ;
	}
  
}
