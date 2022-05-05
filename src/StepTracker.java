import java.util.Scanner;
public class StepTracker {
    int[][] steps = new int[12][30];
    int goal = 10000;
    Scanner scanner = new Scanner(System.in);
    Converter converter = new Converter();
    public void saveSteps()
    {
        int month = 0, day = 0, step = 0;
        System.out.print("Введите номер месяца: ");
        month = scanner.nextInt();
        System.out.print("Введите номер дня: ");
        day = scanner.nextInt()-1;
        System.out.print("Введите количество пройденных шагов: ");
        step = scanner.nextInt();
        if((month >= 0 && month <= 11) && (day >= 0 && day <= 29) && (step >= 0)) {
            steps[month][day] = step;
            System.out.println(">> Успешно сохранено!");
        }
        else System.out.println(">> Ошибка: Введены некорректные данные");

    }
    public void printSteps()
    {
        System.out.print("Введите месяц: ");
        int month = scanner.nextInt();
        if(month >= 0 && month <= 11) {
            int i = 0, sum = 0, max = -1, stepSeries = 0;
            for (i = 0; i < 30; ++i) {
                if (i == 29) System.out.print((i + 1) + " день: " + steps[month][i] + "\n");
                else System.out.print((i + 1) + " день: " + steps[month][i] + ", ");
                sum += steps[month][i];
                if (steps[month][i] > max) max = steps[month][i];
                if (steps[month][i] >= goal) stepSeries++;
            }
            System.out.println("Общее количество шагов за месяц: " + sum);
            System.out.println("Максимальное пройденное количество шагов в месяце: " + max);
            System.out.println("Среднее количество шагов: " + (sum / i));
            System.out.println("Пройденная дистанция (в км): " + converter.stepsToDist(sum));
            System.out.println("Количество сожжённых килокалорий: "+ converter.stepsToCal(sum));
            System.out.println("Лучшая серия: "+ stepSeries);
        }
        else System.out.println(">> Ошибка: Вы ввели неверное значение месяца");
    }
    public void changeSteps() {
        System.out.print("Введите новую цель по количеству шагов: ");
        int gstep = scanner.nextInt();
        if(gstep < 0) System.out.println(">> Ошибка: введенное значение не может быть отрицательным");
        else {
            goal = gstep;
            System.out.println(">> Успешно сохранено!");
        }
    }
}
