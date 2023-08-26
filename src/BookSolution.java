import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BookSolution {
    public static void main(String[] args) throws IOException {

//        134
//        Evening Mail
//        2018
//        79
//
//        178
//        Morning Mail
//        2017
//        65
//
//        176
//        Daily News
//        2017
//        98
//
//        219
//        Times of India
//        1988
//        15
//
//        2017
//        Times of India
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Newspaper[] newspapers = new Newspaper[4];
//        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            int a = Integer.parseInt(br.readLine());
            br.readLine();
            String b = br.readLine();
            br.readLine();
            int c = Integer.parseInt(br.readLine());
            br.readLine();
            int d = Integer.parseInt(br.readLine());
            br.readLine();
            newspapers[i] = new Newspaper(a, b, c, d);
        }
        int input1 = Integer.parseInt(br.readLine());
        br.readLine();
        String input2 = br.readLine();
        int ans2 = findTotalPriceByPublicationYear(newspapers, input1);
        if (ans2 > 0) {
            System.out.println(ans2);
        } else {
            System.out.println("No Newspaper found with the mentioned attribute");
        }

        Newspaper z = searchNewspaperByName(newspapers, input2);
        if (z == null) {
            System.out.println("No Newspaper found with the given name.");
        } else {
            System.out.println("regNo-" + z.regNo);
            System.out.println("name-" + z.name);
            System.out.println("publicationYear-" + z.publicationYear);
            System.out.println("price-" + z.price);
        }
    }

    public static int findTotalPriceByPublicationYear(Newspaper[] newspapers, int input1) {
        int sum = 0;

        for (int i = 0; i < 4; i++) {
            if (newspapers[i].publicationYear == input1) {
                sum += newspapers[i].price;
            }
        }

        if (sum > 0) {
            return sum;
        }
        return 0;
    }

    public static Newspaper searchNewspaperByName(Newspaper[] newspapers, String input2) {
        for (int i = 0; i < 4; i++) {
            if (newspapers[i].name.equalsIgnoreCase(input2)) {
                return newspapers[i];
            }
        }
        return null;
    }
}