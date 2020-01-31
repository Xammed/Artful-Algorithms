package Lab10;

import java.util.Arrays;
import java.util.Random;

public class Driver {
    
    public static void main(String[] args) {
        
    	Item<Integer>[] items = new Item[12];
    	Random rand = new Random();
    	
    	for(int i = items.length-1; i>=0 ; i--) {
    		items[i] = new Item<Integer>(i, ""+rand.nextInt(11));
    	}
    	
    	//KeyBubbleSort(items);
    	
    	for (int i = 0; i <items.length; i++) {
    		System.out.println(items[i].toString() + " " + items[i].getKey());
    	}

    	
    	/*for(int i = 0; i<37; i++) {
    		int[] test = makeRandomArray();
    		System.out.println(Arrays.toString(test));
    		System.out.println("Merge Sorted: "+Arrays.toString(MergeSort(test)));
    		test = makeRandomArray();
    		System.out.println(Arrays.toString(test));
    		QuickSort(test, 0, test.length-1);
    		System.out.println("Quick Sorted: "+Arrays.toString(test)+ "\n");
    	}*/
    	
    }
    

    
    private static int[] makeRandomArray() {
    	Random rand = new Random();
    	int[] randArray = new int[8];
    	for (int i = 0; i<randArray.length;i++) {
    		randArray[i] = rand.nextInt(20);
    	}
    	return randArray;
    }
     
    private static int[] MergeSort(int[] data) {
    	int[] temp = new int[data.length];
      	
      	for(int i = 1; i<=data.length; i*=2) {
      		for(int j = 0; j<=data.length-i; j+=i) {
      			mergeProgressive(data, temp, j, j+(i/2)-1,j+i-1);
      			//System.out.println(Arrays.toString(temp));
      		}
      		data = temp; temp= new int[data.length];
      	}

      	return data;
      }
    
    
     private static void mergeProgressive(int[] data, int[] building, int start, int a, int b) {
    	System.arraycopy(data,  b,  building,  b,  data.length-b);
    	int i =start; int j=a+1; int k =start;
   	  	while(i<=a && j<=b) {
   	  		if(data[i]<=data[j]) {
   	  			building[k++] = data[i++];
   	  		}
      		else {
      			building[k++] = data[j++];
      		}
   	  	}
   	  	//System.out.println("i: " + i + " j: " +j+ " k: " +k);
   	  	if(i>=a && j<=b) {
   		  System.arraycopy(data,  j,  building, k, b-j+1);
   	  	}
   	  	else {
   		  System.arraycopy(data,  i,  building, k, a-i+1);
   	  	}
      }
      
      
    
     private static void QuickSort(int[] data, int lower, int upper) {
    	 if(data.length==1 || lower>=upper) {
    		 return;
    	 }
         int i = lower, j = upper;
         int pivot;
         if (data.length>3) {
        	 if (data[2]>data[0]) {
        		 if(data[1]<data[2] && data[1]>data[0]) {
        			 pivot = data[1];
        		 }
        		 else {
        			 pivot = data[0];
        		 }
        	 }
        	 else {
        		 if(data[1]<data[0] && data[1]>data[2]) {
        			 pivot = data[1];
        		 }
        		 else {
        			 pivot = data[0];
        		 }
        	 }
         }
         else {
        	 pivot = data[0];
         }

         while (i <= j) {
             while (data[i] < pivot) {
                 i++;
             }
             while (data[j] > pivot) {
                 j--;
             }
             if (i <= j) {
                 int temp = data[i];
                 data[i] = data[j];
                 data[j] = temp;
                 i++;
                 j--;
             }
         }
         if (lower < j)
             QuickSort(data, lower, j);
         if (i < upper)
             QuickSort(data, i, upper);
     }
     
     
      
      private static int[] merge(int[] a, int[] b) {
      	int[] merged = new int [a.length + b.length];
      	int i =0; int j=0; int k =0;
      	while(i<a.length && j<b.length) {
      		if(a[i]<=b[j]) {
      			merged[k] = a[i];
      			i++;
      		}
      		else {
      			merged[k] = b[j];
      			j++;
      		}
      		k++;
      	}
      	if(i==a.length) {
      		System.arraycopy(b,  j,  merged, k, b.length-j);
      	}
      	else {
      		System.arraycopy(a,  i,  merged, k, a.length-i);
      	}
      	
      	return merged;
      }
      
      

	private static <T> void KeyBubbleSort(Item<T>[] data) {
    	for(int i = 0; i< data.length; i++) {
            for(int j = i+1; j<data.length; j++) {
            	System.out.println(data[j].getKey() + " " + data[i].getKey() + " " + data[j].compareTo(data[i]));
                if(data[j].compareTo(data[i])>0) {
                    Item<T> temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
    }
    
    
    private static void BubbleSort(int[] data) {
        for(int i = 0; i< data.length; i++) {
            for(int j = i+1; j<data.length; j++) {
                if(data[j]<data[i]) {
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
    }

    private static void ImprovedBubbleSort(int[] data) {
        boolean resume = true;
        for(int i = 0; i< data.length && resume; i++) {
            boolean swapped = false;
            for(int j = i+1; j<data.length; j++) {
                if(data[j]<data[i]) {
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                    swapped = true;
                }
            }
            resume = swapped;//That or break, right?
        }
    }

    private static void SelectionSort(int[] data) {
        for(int i = 0; i<data.length; i++) {
            int maxValindex = 0;
            int temp = data[data.length-1-i];
            for(int j = data.length-1-i; j>0; j--) {
                if (data[j-1]>data[j]) {
                    maxValindex = j-1;
                }
            }
            data[data.length-1-i] = data[maxValindex];
            data[maxValindex] = temp;
        }

    }

    private static void ImprovedSelectionSort(int[] data) {
        for(int i = 0; i<data.length; i++) {
            int maxValindex = 0;
            for(int j = data.length-1-i; j>0; j--) {
                if (data[j-1]>data[j]) {
                    maxValindex = j-1;
                }
            }
            if(maxValindex!=data.length-i-1) {
                int temp = data[data.length-1-i];
                data[data.length-1-i] = data[maxValindex];
                data[maxValindex] = temp;
            }
        }

    }

    private static void InsertionSort(int[] data) {
        for (int i = 1; i<data.length; i++) {
            int newLocation = LinearSearch(data, data[i], 0, i);
            int shifted = data[i];
            for(int j = i; j>newLocation; j--) {
                data[j] = data[j-1];
            }
            data[newLocation] = shifted;
        }
    }

    private static void ImprovedInsertionSort(int[] data) {
        for (int i = 1; i<data.length; i++) {
            int newLocation = BinarySearch(data, data[i], 0, i);
            int shifted = data[i];
            for(int j = i; j>newLocation; j--) {
                data[j] = data[j-1];
            }
            data[newLocation] = shifted;
        }
    }
    private static int LinearSearch(int[] data, int searchKey, int lower, int upper) {
        for(int i = lower; i<=upper; i++) {
            if(data[i]>=searchKey) {
                return i;
            }
        }
        return upper;
    }

    private static int BinarySearch(int[] data, int searchKey, int lower, int upper) {
        if(data[lower]<searchKey) {
            int mid = (lower + upper)/2;
            while(lower!=mid || upper!=mid) { //This is to account for extrema, will think on it.
                if (data[mid]<searchKey) {
                    lower = mid;
                }
                else {
                    upper = mid+1;
                }
                mid = (lower + upper)/2;
            }
            return mid+1;
        }
        else {
            return 0;
        }
    }
    
    


}