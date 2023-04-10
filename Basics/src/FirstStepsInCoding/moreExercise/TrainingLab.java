package FirstStepsInCoding.moreExercise;

import java.util.Scanner;

public class TrainingLab {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double w = Double.parseDouble(scan.nextLine());  // дължината в метри
        double h = Double.parseDouble(scan.nextLine()); //  ширината в метри

         // преобразуваме в см. , защото по условие всички стойности в зад. са в см
        // 1 м = 100 см
        w *= 100;
        h *= 100;

        // от ширината на залата махаме 100 см за коридора;
        h -= 100;

          // 70 см е широко едно раб.място по условие
         // разделяме ширината на залата / ширината на едно работно място => колко редове с бюра можем да имаме
        //използваме Math-библиотеката, защото ни трябва цяло число, а извършваме дробно деление;
        double rows = Math.floor(h / 70);

         // 120 см е дълго едно бюро
        // разделяме дължината на залата / дължината на едно бюро => колко колони с бюра можем да имаме;
        double column = Math.floor(w / 120);

         // умножаваме редовете * колоните => колко бюра общо можем да поберем
        //  махаме трите места за катедрата и вратата по условие
        double desks = (rows * column) - 3;

        System.out.print(String.format("%.0f",desks));
    }
}
