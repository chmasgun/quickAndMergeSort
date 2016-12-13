import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;


public class QuickAndMergeSort {


	public static void main(String[] args) {
		
		Random rgen=new Random();
		try{
			BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter data size: ");
			int floors =Integer.parseInt(br.readLine());
			
			int[] num = new int[floors];

			

			for(int i=0; i<floors; i++){
				num[i]=rgen.nextInt(1000);

			}
			long cl=System.currentTimeMillis();
			showArray(num);
			// can be written num=mergeSort(num); instead
			quickSort(num,0,num.length-1);
			long cl2=System.currentTimeMillis();
			System.out.println("\nOrdered: ");
			showArray(num);
			System.out.println("\nOperation took: "+ (cl2-cl)+" ms");
			
			
		} catch(Exception e){
			e.printStackTrace();
		}


	}

	private static  void showArray(int[] array){
		for(int index=0; index<array.length; index++){
			System.out.print(" "+array[index]);
		}
	}
	private static  void quickSort(int array[],int init,int end){
		if(init<end){
			int length=end-init+1;
			int pivot=array[init+length-1];
			int partition=0;
			for(int i=0;i<length-1;i++){
				if(array[init+i]<pivot){
					swap(array,init+partition,i+init);
					partition++;
				}
			}
			
			swap(array,init+partition,init+length-1);

			//		showArray(array);

			quickSort(array,init,init+partition-1);

			quickSort(array,init+partition+1,end);
		}
	}


	private static int[] mergeSort(int[] array){
		int length=array.length;
		if(length==1){return array;}
		int[] sub1=new int[length/2];
		int[] sub2=new int[length-length/2];
		for(int ind=0;ind<length/2;ind++){
			sub1[ind]=array[ind];
		}
		int cnt=0;
		for(int ind=length/2;ind<length;ind++){
			sub2[cnt]=array[ind];
			cnt++;
		}
		sub1=mergeSort(sub1);
		sub2=mergeSort(sub2);
		array=merge(sub1,sub2);
		return array;
	}
	private static int[] merge(int[] sub1,int[] sub2){
		int total=sub1.length+sub2.length;
		int[] merged=new int[total];
		int pt1=0,pt2=0;
		for(int i=0;i<total;i++){
			if(pt1==sub1.length){
				merged[i]=sub2[pt2];
				pt2++;
			}else if(pt2==sub2.length){
				merged[i]=sub1[pt1];
				pt1++;
			}else{
				if(sub1[pt1]<sub2[pt2]){
					merged[i]=sub1[pt1];
					pt1++;
				}else{
					merged[i]=sub2[pt2];
					pt2++;
				}
			}
		}

		return merged;
	}
	private static  void swap(int[] array,int pos1,int pos2){
		int temp=array[pos1];
		array[pos1]=array[pos2];
		array[pos2]=temp;
	}
}
