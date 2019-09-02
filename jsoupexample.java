package sql1;

import java.io.*;
import java.lang.*;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import java.sql.*;
class jsoupexample 
{
	public static void main(String args[]) throws IOException
	{
		jsoupexample electioninfo=new jsoupexample();
		electioninfo.state();
		electioninfo.unt();

	}
   public void state() throws IOException
   {
	   int no_of_cons[]={25,2,14,40,2,26,10,4,6,28,20,29,48,2,2,1,1,21,13,25,1,29,2,80,42,11,14,5,17};
		String name_of_state[]={"Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Goa","Gujrat","Harayana","Himachal Pradesh","Jammu and Kashmir","Karnataka","Kerala","Madhya Pradesh","Maharastra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Tripura","Uttar Pradesh","West Bengal","Chhattisgarh","Jharkhand","Uttarakhand","Telangana"};
		int statecode,con_code,i1=0,j1,k1;
		for(statecode=1;statecode<=29;statecode++)
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
		                   String serial_no = row.select("td:nth-of-type(1)").text();
		                   String can_name=row.select("td:nth-of-type(2)").text();
		                   String party=row.select("td:nth-of-type(3)").text();
		                   String won=row.select("td:nth-of-type(4)").text();
		                   String nvote=row.select("td:nth-of-type(6)").text();
		                   String per_of_vote=row.select("td:nth-of-type(7)").text();
		                   if(i1==12)
		                   {
		                	   
		                	   String removeFromThisPart = "Result";

		                	   serial_no = serial_no .substring(0, serial_no .lastIndexOf( removeFromThisPart ));

		                	   System.out.println(serial_no);
		                   }
		                   if(i1>12)
		                   System.out.println(serial_no+" "+can_name+" "+party+" "+won+" "+nvote+" "+per_of_vote+" "+statecode+" "+i1);
		                   if(can_name.equals("NOTA"))
		                   break;
		                }
		        }
			    i1=0;
			    }//closing of if(i>9)
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
			                   String serial_no = row.select("td:nth-of-type(1)").text();
			                   String can_name=row.select("td:nth-of-type(2)").text();
			                   String party=row.select("td:nth-of-type(3)").text();
			                   String won=row.select("td:nth-of-type(4)").text();
			                   String nvote=row.select("td:nth-of-type(6)").text();
			                   String per_of_vote=row.select("td:nth-of-type(7)").text();
			                   if(i1==12)//for constituency name
			                   {
			                	   
			                	   String removeFromThisPart = "Result";

			                	   serial_no = serial_no .substring(0, serial_no .lastIndexOf( removeFromThisPart ));

			                	   System.out.println(serial_no);
			                   }
			                   else if(i1>12)
			                   System.out.println(serial_no+" "+can_name+" "+party+" "+won+" "+nvote+" "+per_of_vote+" "+statecode+" "+i1);
			                   if(can_name.equals("NOTA"))
			                   break;
			                }
			        }
				    i1=0;
			    }
			}
		}//end of state
   }
  public void unt() throws IOException	
		{
			int uno_of_cons[]={1,1,1,1,7,1,1};
			//String name_of_ut[]={"Andaman & Nicobar Islands","Chandigarh","Dadra & Nagar Haveli","Daman & Diu","Delhi","Lakshadweep","Puducherry"};
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
			                   String serial_no = row.select("td:nth-of-type(1)").text();
			                   String can_name=row.select("td:nth-of-type(2)").text();
			                   String party=row.select("td:nth-of-type(3)").text();
			                   String won=row.select("td:nth-of-type(4)").text();
			                   String nvote=row.select("td:nth-of-type(6)").text();
			                   String per_of_vote=row.select("td:nth-of-type(7)").text();
			                   if(i2==12)
			                   {
			                	   
			                	   String removeFromThisPart = "Result";

			                	   serial_no = serial_no .substring(0, serial_no .lastIndexOf( removeFromThisPart ));

			                	   System.out.println(serial_no);
			                   }
			                   if(i2>12)
			                   System.out.println(serial_no+" "+can_name+" "+party+" "+won+" "+nvote+" "+per_of_vote+" "+ut+" "+i2);
			                   if(can_name.equals("NOTA"))
			                   break;
			                }
			        }
				    i2=0;
				 }
			}//end of ut
		}
}

