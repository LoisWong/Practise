
public class hindex {
	public int hIndex(int[] citations) {
        int len = citations.length;
        int[] count = new int[len+1];
        //初始化mapping，记录各个引用量的次数
        for (int c:citations){
        	if (c >= len){
        		count[len]++;
        	}else{
        		count[c]++;}
        }
        //引用量的次数的统计对比mapping指标，一旦达到就返回h值，保证h最大
        int max=0;
        while (len>0){
        	max += count[len];
        	if (max >= len){
        		return len;
        	}
        	len--;
        }
        return 0;
    }
}
