import java.util.*;

public class StringBag implements SimpleCollection {
    private String[] bag;
    private  int elements;
    
    public StringBag(int n) {
        elements = 0;
        bag = new String[n];
    }
    
    public boolean add (String s) {
        for (int i = 0; i < bag.length(); i++)
            if (!bag[i]) {
                bag[i] = s;
                bag.length() = bag.length() + 1;
                return true;
            }
        }
    }
    
   public void clear() {
        for (int i = 0; i < bag.length(); i++) {
            bag[i] = null;
        }
    }
    
    public boolean contains(String s) {
        for (int i = 0; i < bag.length(); i++) {
            if (bag[i] = s) {
                return true;
            }
            else {
                return false;
            }
                
        }
    }
    
    public boolean isEmpty() {
        for (int i = 0; i < bag.length(); i++) {
            if( bag[i] != null) {
                return false;
            }
        }
        else {
            return true;
        }
    }
    
    public boolean remove (String s) {
        int position = indexOf(s);
        if (position == -1) {
            return false;
        }        
        else {
            bag[position] = bag[elements - 1];
            bag[elements - 1] = null;
            elements--;
            return true;
        }
    }
        
    public int size() {
        int counter;
        for( int i = 0; i < bag.length(); i++) {
            if ( bag[i] != null) {
                counter++;
            }
        }
        return counter;
    }
        
    public String[] toArray() {
        String[] temp = new StringBag();
        return bag;   
    }
    
    public static void main (String[] args) {
        StringBag bag = new StringBag(5);
        bag.add("A");
        
    }
}