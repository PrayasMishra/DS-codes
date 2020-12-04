package networking;

class NetworkId{
	static String findClass(String str){ 
	
		int index = str.indexOf('.'); 
		
		String ipsub = str.substring(0,index); 
		int ip = Integer.parseInt(ipsub); 

		if (ip>=1 && ip<=127)
			return "A";

		else if (ip>=128 && ip<=191) 
			return "B"; 

		else if (ip>=192 && ip<223) 
			return "C"; 

		else if (ip >=224 && ip<=239) 
			return "D"; 

		else
			return "E"; 
	} 

	static void seprate(String str, String ipClass){ 
		
		String network = "", host = "";
		int strLen = str.length();

		if(ipClass == "A"){ 
			int index = str.indexOf('.'); 
			network = str.substring(0,index); 
			host = str.substring(index+1,strLen);
		}
		else if(ipClass == "B"){

			int index = -1; 
			int dot = 2; 
			for(int i=0;i<str.length();i++){ 
				if(str.charAt(i)=='.'){ 
					dot -=1; 
					if(dot==0){ 
						index = i; 
						break;
					} 
				} 
			} 
			network = str.substring(0,index); 
			host = str.substring(index+1,strLen);
		}
		else if(ipClass == "C"){

			int index = -1; 
			int dot = 3; 
			for(int i=0;i<str.length();i++){ 
				if(str.charAt(i)=='.'){ 
					dot -=1; 
					if(dot==0){ 
						index = i; 
						break;					 
					} 
				} 
			} 
			network = str.substring(0,index); 
			host = str.substring(index+1,strLen);
		}
		else if(ipClass == "D" || ipClass == "E"){
			System.out.println("In this Class, IP address"+ 
			" is not divided into Network and Host IDs"); 
			return; 
		} 
		System.out.println("Network ID : "+network);
		System.out.println("Host ID : "+host);
	}

	public static void main(String[] args) { 
		String str = "122.226.12.11";
		String ipClass = findClass(str);
		System.out.println("Given IP address belongs to class "+ipClass);
		seprate(str,ipClass); 
	} 
} 
