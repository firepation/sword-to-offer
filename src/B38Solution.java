import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B38Solution {
	public static void main(String[] args) {
		B38Solution p = new B38Solution();
        System.out.println(p.Permutation(abc).toString());
    }
 
    public ArrayListString Permutation(String str) {
        ListString res = new ArrayList();
        if (str != null && str.length()  0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return (ArrayListString)res;
    }
 
    public void PermutationHelper(char[] cs, int i, ListString list) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val))
                list.add(val);
        } else {
            for (int j = i; j  cs.length; j++) {
                swap(cs, i, j);
                PermutationHelper(cs, i+1, list);
                swap(cs, i, j);
            }
        }
    }
 
    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}