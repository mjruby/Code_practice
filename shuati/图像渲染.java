package leetcode;
// 输入:
//image = [[1,1,1],[1,1,0],[1,0,1]]
//sr = 1, sc = 1, newColor = 2
//输出: [[2,2,2],[2,2,0],[2,0,1]]
//解析:
//在图像的正中间，(坐标(sr,sc)=(1,1)),
//在路径上所有符合条件的像素点的颜色都被更改成2。
//注意，右下角的像素没有更改为2，
//因为它不是在上下左右四个方向上与初始点相连的像素点。
//
public class 图像渲染 {
    public static void main(String[] args) {
        int[][] img = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        int sr =1,sc=1, newColor = 2;
        printArrs(img);
        int[][] res = floodFill(img, sr, sc, newColor);
        printArrs(res);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || sr >= image.length || sc >= image[0].length)
            return new int[][]{};

        int orignColor = image[sr][sc];
        int[][] visited = new int[image.length][image[0].length];
        fill(image,sr,sc,orignColor,newColor);
        return image;
    }


    // 方法一： -1 标记
    public static void fill(int[][] img,int sr,int sc,int orignColor,int newColor){
        if(sr < 0 || sc < 0 || sr >= img.length || sc >= img[0].length) return;  // 超出边界
        if(img[sr][sc] != orignColor) return; // 遇到其他区域
        // 当 orignColor == newColor 会出错，要处理
//        img[sr][sc] = newColor;
        img[sr][sc] = -1;
        fill(img,sr+1,sc,orignColor,newColor);
        fill(img,sr-1,sc,orignColor,newColor);
        fill(img,sr,sc+1,orignColor,newColor);
        fill(img,sr,sc-1,orignColor,newColor);
        img[sr][sc] = newColor;
    }


    // 方法二 ：增加一个visited 数组
    public static void fill(int[][] img,int sr,int sc,int orignColor,int newColor,int[][] visited){
        if(sr < 0 || sc < 0 || sr >= img.length || sc >= img[0].length) return;  // 超出边界
        if(img[sr][sc] != orignColor) return; // 遇到其他区域
        if(visited[sr][sc] != 0) return;  // 访问过了
        img[sr][sc] = newColor;
        visited[sr][sc] = 1;
        fill(img,sr+1,sc,orignColor,newColor);
        fill(img,sr-1,sc,orignColor,newColor);
        fill(img,sr,sc+1,orignColor,newColor);
        fill(img,sr,sc-1,orignColor,newColor);

    }
    // 打印二维数组
    public static void printArrs(int[][] arr){
        if(arr == null || arr.length == 0) return;
        int nrow = arr.length;
        int ncol = arr[0].length;
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
