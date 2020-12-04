
import java.util.*;
class EvenWord{

	static int solution(String str) {
		int res = solution2(str.toCharArray(), str.length());
		return res;
	}

	static int solution2(char[] str, int N)
	{
		HashMap<Character,Integer> hashMap = new HashMap<>();
		PriorityQueue<Integer> queue =	new PriorityQueue<>((x, y) -> Integer.compare(y, x));

		int count1 = 0;
		for (int i = 0; i < N; i++)
		{
			if(hashMap.containsKey(str[i])){
				hashMap.put(str[i],
						hashMap.get(str[i]) + 1);
			}else
			{
				hashMap.put(str[i], 1);
			}
		}


		for (Map.Entry<Character,
				Integer> it :
				hashMap.entrySet())
		{
			queue.add(it.getValue());
		}

		while (!queue.isEmpty())
		{
			int freq = queue.peek();
			queue.remove();

			if (queue.isEmpty()) {
				return count1;
			}

			if (freq == queue.peek())
			{
				if (freq > 1)
				{
					queue.add(freq - 1);
				}

				count1++;
			}
		}

		return count1;
	}

	public static void main(String[] args)
	{
		String str = "axxaxa";


		int N = str.length();
		System.out.print(solution(str));
	}


}