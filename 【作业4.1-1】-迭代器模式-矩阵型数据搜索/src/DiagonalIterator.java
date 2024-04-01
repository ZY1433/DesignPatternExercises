import java.util.ArrayList;

public class DiagonalIterator implements NumberIterator{
    private static final ArrayList<Integer> numList = new ArrayList<>();
    static int nextIndex=-1;
    public DiagonalIterator(Matrix mx) {
        int[][] mat = mx.getMatrixData();
        int len = mx.getLength();
        for(int i=0; i<len; i++){
            int t = i;
            for(int j=0; j<=i; j++){
                numList.add(mat[j][t--]);
            }
        }//上半
        int t = 0;
        for(int i=len-1; i>0; i--){
            t++;int idx = len-1;
            for(int j=t; j<len; j++){
                numList.add(mat[j][idx--]);
            }
        }
    }
    @Override
    public boolean hasNext() {
        if(nextIndex < numList.size()-1){
            nextIndex++;
            return true;
        }
            return false;
    }
    @Override
    public int next(){
        return numList.get(nextIndex);
    }
    @Override
    public void remove() {
        numList.remove(nextIndex);
        nextIndex--;
    }
    @Override
    public int getNumOfItems(){
        return numList.size();
    }

//    public static void main(String[] args) {
////        int[][] matrix = {
////                {01, 02, 03, 04, 05},
////                {11, 12, 13, 14, 15},
////                {21, 22, 23, 24, 25},
////                {31, 32, 33, 34, 35},
////                {41, 42, 43, 44, 45}
////        };
////
////        traverseDiagonally(matrix);
//        Matrix m = new Matrix();
//        int len = m.getLength();
//        DiagonalIterator t = new DiagonalIterator(m);
//        int a = 0;
//        while (t.hasNext()){
//            a++;
//            int s = t.next();
//            System.out.println(len+" "+ s + " " + a);
//        }
//        System.out.println(numList.size());
////        System.out.println(t.next());
//    }
//
//    public static void traverseDiagonally(int[][] matrix) {
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//
//        // 遍历对角线上方的部分
////        for (int i = 0; i < rows; i++) {
////            for (int j = 0; j <= i && j < cols; j++) {
////                System.out.print(matrix[i - j][j] + " ");
////            }
////            System.out.println();
////        }
//        int t = 0;
//        for(int i=rows-1; i>0; i--){
//            t++;int idx = rows-1;
//            for(int j=t; j<rows; j++){
//                System.out.print(matrix[j][idx--]+ " ");
//            }
//            System.out.println();
//
//        }
//
////        // 遍历对角线下方的部分
////        for (int i = 1; i < cols; i++) {
////            for (int j = 0; j < rows && (i + j) < cols; j++) {
////                System.out.print(matrix[rows - 1 - j][i + j] + " ");
////            }
////            System.out.println();
////        }
//    }
}
