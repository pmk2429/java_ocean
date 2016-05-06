package matrix;

public class MatrixRotation1 {
	public static void main(String[] arr){
		int[][] matrix = new int[6][6];
		int i, j, k, temp;
		for(i =0; i<6; i++){
			for (j=0; j<6; j++)
				matrix[i][j] = i*10+j;
		}
		
		System.out.println("before transpose");
		for(i =0; i<6; i++){
			for (j=0; j<6; j++)
				System.out.print("\t"+matrix[i][j]);
			System.out.println();
		}
		
		System.out.println("after transpose");
		//Transpose of matrix
		for(i =0; i<6; i++){
			for (j=i; j<6; j++)
				if(i!=j){
					temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
		}
		
		for(i =0; i<6; i++){
			for (j=0; j<6; j++)
				System.out.print("\t"+matrix[i][j]);
			System.out.println();
		}
		
		//rotate 90 degree
		for(i=0, k =5 ; i < k; i++, k--){
			for (j=0; j<6; j++){
				//System.out.println("matrix[i][j] = "+ matrix[i][j] + "    matrix[k][j] = " + matrix[k][j]);
				temp = matrix[j][i];
				matrix[j][i] = matrix[j][k] ;
				matrix[j][k] = temp ;
			}
				
		}
		
		System.out.println("after 90 degree rotation");
		for(i =0; i<6; i++){
			for (j=0; j<6; j++)
				System.out.print("\t"+matrix[i][j]);
			System.out.println();
		}
	}
}