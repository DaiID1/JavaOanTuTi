import java.util.Random;
import java.util.Scanner;

public class XuLy {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		int playerWins = 0;
		int aiWins = 0;

		while (true) {
			System.out.println("\n===== Oẳn Tù Tì =====");
			System.out.println("1. Kim");
			System.out.println("2. Bao");
			System.out.println("3. Kéo");
			System.out.println("0. Nghỉ chơi");
			System.out.print("Bạn chọn: ");

			int choice = sc.nextInt();
			if (choice == 0)
				break;

			int aiChoice = rand.nextInt(3) + 1;

			int result = playRound(choice, aiChoice);
			if (result == 1)
				playerWins++;
			else if (result == -1)
				aiWins++;
		}

		printFinalResult(playerWins, aiWins);
		sc.close();
	}

	public static String convertChoice(int c) {
		switch (c) {
		case 1:
			return "Búa";
		case 2:
			return "Bao";
		case 3:
			return "Kéo";
		default:
			return "Không hợp lệ";
		}
	}

	public static int playRound(int playerChoice, int aiChoice) {
		System.out.println("Người chơi chọn: " + convertChoice(playerChoice));
		System.out.println("Máy chọn: " + convertChoice(aiChoice));

		if (playerChoice == aiChoice) {
			System.out.println("Kết quả: Hòa");
			return 0;
		} else if ((playerChoice == 1 && aiChoice == 3) || (playerChoice == 2 && aiChoice == 1)
				|| (playerChoice == 3 && aiChoice == 2)) {
			System.out.println("Kết quả: Người chơi thắng");
			return 1;
		} else {
			System.out.println("Kết quả: Máy thắng");
			return -1;
		}
	}

	public static void printFinalResult(int playerWins, int aiWins) {
		System.out.println("\n===== KẾT QUẢ CUỐI =====");
		System.out.println("Tỷ số là: Người chơi: " + playerWins + " ---- AI: " + aiWins);

		if (playerWins > aiWins) {
			System.out.println("Người chơi thắng nhiều nhất!");
		} else if (aiWins > playerWins) {
			System.out.println("Máy thắng nhiều nhất!");
		} else {
			System.out.println("Hai bên hòa nhau!");
		}
	}

	
}
