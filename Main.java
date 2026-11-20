import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("1 — рассчитать итоговую сумму");
            System.out.println("2 — найти процент по начальной и конечной суммам");
            System.out.print("Режим: ");
            int mode = Integer.parseInt(in.nextLine().trim());
            if (mode == 1) {
                double principal = read(in, "Начальная сумма: ");
                double percent = read(in, "Процент за период: ");
                int periods = Integer.parseInt(prompt(in, "Количество периодов: "));
                if (principal < 0 || percent <= -100 || periods < 0) throw new IllegalArgumentException("Недопустимые исходные данные.");
                System.out.printf("Итоговая сумма: %.2f%n", principal * Math.pow(1 + percent / 100, periods));
            } else if (mode == 2) {
                double start = read(in, "Начальная сумма: ");
                double end = read(in, "Конечная сумма: ");
                int periods = Integer.parseInt(prompt(in, "Количество периодов: "));
                if (start <= 0 || end < 0 || periods <= 0) throw new IllegalArgumentException("Суммы или периоды вне допустимого диапазона.");
                System.out.printf("Процент за период: %.4f%%%n", (Math.pow(end / start, 1.0 / periods) - 1) * 100);
            } else System.out.println("Выберите режим 1 или 2.");
        } catch (NumberFormatException e) { System.out.println("Ошибка: введите число."); }
          catch (IllegalArgumentException e) { System.out.println("Ошибка: " + e.getMessage()); }
    }
    private static String prompt(Scanner in, String text) { System.out.print(text); return in.nextLine().trim(); }
    private static double read(Scanner in, String text) { return Double.parseDouble(prompt(in, text).replace(',', '.')); }
}
