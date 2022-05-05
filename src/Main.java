import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        StepTracker st = new StepTracker();
        printMenu();
        int userInput = scanner.nextInt();
        while (userInput != 4) {
            if(userInput == 1) {
                st.saveSteps();
            }
            else if(userInput == 2) {
                st.printSteps();
            }
            else if(userInput == 3) {
                st.changeSteps();
            }
            else System.out.println(">> Ошибка: Вы выбрали несуществующий пункт меню");
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Напечатать статистику за определённый месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("4. Выйти из приложения");
    }
}
