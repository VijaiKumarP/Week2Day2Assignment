package Week2.Day2;

public class RemoveDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "We learn java basics as part of java sessions in java week1";	
		int iCount=0;
		String[] split = text.split(" ");

		for (int i = 0; i < split.length; i++) {
			for (int j = 0; j < split.length; j++) {
				if (i==j) {
					continue;
				}
				if (split[j].equals(split[i])) {
					iCount=iCount+1;

				}
				
				if (iCount >0) {
					//split[j].replace(split[j], "");
					split[j]="";
					iCount=0;
				}
				
			}


			
			iCount=0;
			
		}
		
		String resTxt="";
		
		for (int k = 0; k < split.length; k++) {
			resTxt= resTxt + split[k] + " ";
		}
		System.out.println("Result Text after removing Duplicates : '" +resTxt + "'");
		
	}

}
