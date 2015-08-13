
public class MostContainer {
	public static void main(String[] args){
		int[] height = {1,2,4,3};
		System.out.println(maxArea(height));
	}
	public static int maxArea(int[] height) {
        int area;
        int max = 0;
        int near = 0;
        int far = height.length-1;
        //The original idea, it is simple and accurate, however takes time
        /*for (int i = 0; i < height.length-1; i++){
        	for (int j = i+1; j < height.length; j++) {
				area = Math.min(height[i], height[j]) * (j-i);
				if (area > max) {
					max = area;
				}
			}
        }*/
        while (near < far){
        	area = Math.min(height[near], height[far]) * (far - near);
        	if (area > max){
        		max = area;
        	}
        	if (height[near] > height[far]){
        		int low = height[far];
        		do{far--;}while(height[far]<low);
        	}else {
        		int low = height[near];
        		do{near++;}while(height[near]<low);
        	}
        }	
        return max;	
    }
}
