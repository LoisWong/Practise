package Triangle;


public class triangle {
	public static void main(String[] args){
		//Getting three integer inputs
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		
		try {
			//See if the edges are valid
			if(Judge(a,b,c)) {
				//Calculate the area of triangle
				float area = Area(a,b,c);
				System.out.print(area);
			}
		}
		catch (InvalidTriangleException e) {
			System.out.println("");
		}
	}
	

	private static boolean Judge(int a, int b, int c) throws InvalidTriangleException{
		//If there are negative,(throw) InvalidTriangleException
		if (a < 0 || b < 0 || c < 0){
			throw new InvalidTriangleException();
		}
		//Inputs that cannot form a valid triangle,(throw) InvalidTriangleException
		int aa = a*a;
		int bb = b*b;
		int cc = c*c;
		if (aa + bb <= cc || aa + cc <= bb || bb + cc <= aa){
			throw new InvalidTriangleException();
		}
		return true;
	}


	private static float Area(int a, int b, int c) {
		float area = 0;
		
		//The Heron's Formula that calculate triangle's area
		//https://en.wikipedia.org/wiki/Heron's_formula
		float s = (a + b + c)/2;
		float areaS = s * (s - a) * (s - b) * (s - c);
		area = (float) Math.sqrt(areaS);
		return area;
	}

}
