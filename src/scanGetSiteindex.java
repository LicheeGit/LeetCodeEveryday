import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @Author Lichee
 * @Date 2020/10/5 14:20
 * @Version 1.0
 */
public class scanGetSiteindex {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("请输入要删除的点的索引");
            System.out.println("索引范围：(0~49)");
            int input = scanner.nextInt();
            if(input>=0&&input<=49){
                System.out.print(input);
            }
            System.out.println();
        }catch (InputMismatchException e){

        }

        /*System.out.println("请输入要删除的点的坐标");
        System.out.print("x: ");
        double x = scanner.nextDouble();
        if(x>=-.05&&x<=1.05){
            System.out.print(x);
        }
        System.out.println();
        System.out.print("y: ");
        double y = scanner.nextDouble();
        if(y>=-.05&&y<=1.05){
            System.out.print(y);
        }
        System.out.printf("(%f, %f)", x,y);*/
    }

}
