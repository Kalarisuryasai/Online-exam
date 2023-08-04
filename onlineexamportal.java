import java.util.*;

class OnlineExamPortal {
    Scanner sc = new Scanner(System.in);
    HashMap<String, Integer> info = new HashMap<String, Integer>();
    boolean isLoggedIn = false;

    public OnlineExamPortal() {
        info.put("surya", 4317);
        info.put("sitarama", 4317);
        info.put("indra", 4336);
        info.put("siva", 4289);
        info.put("karthik", 204073);
        info.put("vamsi", 204016);
    }

    public void login() {
        System.out.println("**** Welcome to OASIS INFOBYTE ****");
        System.out.println("LOGIN");
        System.out.println("Enter Username:");
        String id = sc.next();
        System.out.println("Enter Password:");
        int pwd = sc.nextInt();
        if (info.containsKey(id) && info.get(id) == pwd) {
            System.out.println("\nLogin successful!");
            isLoggedIn = true;
            menu();
        } else {
            System.out.println("\nInvalid Username or Password.\nTry again!!!\n");
            login();
        }
    }

    public void menu() {
        if (!isLoggedIn) {
            login();
        }

        int ch;
        System.out.println("\nEnter your Choice:");
        System.out.println("1.Update profile \n2.Start Exam \n3.Logout");
        ch = sc.nextInt();
        switch (ch) {
            case 1:
                update();
                menu();
                break;
            case 2:
                startExam();
                menu();
                break;
            case 3:
                System.out.println("Logged out successfully");
                isLoggedIn = false;
                break;
            default:
                System.out.println("Wrong choice!!! Choose correct choice");
                menu();
        }
    }

    public void update() {
        System.out.println("Enter Username:");
        String update_id = sc.next();
        System.out.println("Enter Old Password:");
        int update_pwd = sc.nextInt();
        if (info.containsKey(update_id) && info.get(update_id) == update_pwd) {
            System.out.println("Enter New Password:");
            update_pwd = sc.nextInt();
            info.replace(update_id, update_pwd);
            System.out.println("Password Changed Successfully!!!");
        } else {
            System.out.println("User not found.\n");
        }
    }

    public void startExam() {
        if (!isLoggedIn) {
            login();
        }

        long startTime = System.currentTimeMillis();
        long endTime = startTime + 30000; // 30 seconds (adjust this as per your requirement)
        int score = 0, ans;
        System.out.println("Welcome to Oasis InfoByte quiz !!!");
        while (System.currentTimeMillis() < endTime) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("Q1.Who is the father of the computer?");
            System.out.println("1.Dennis Ritchie \t2.Charles Babbage \t3.Bill Gates \t4.James Gosling");
            System.out.print("Enter Option: ");
            ans = sc.nextInt();
            if (ans == 2) {
                score += 5;
            } else {
                score--;
            }

            System.out.println("-------------------------------------------------------------");
            System.out.println("Q2.What is know as temporary memory or volatile memory ?");
            System.out.println("1.SSD \t2.HDD \t3.RAM \t4.ROM ");
            System.out.print("Enter Option: ");
            ans = sc.nextInt();
            if(ans == 3)
                score+=5;
            else
                score--;

            System.out.println("-------------------------------------------------------------");
            System.out.println("Q3.What is Half Byte called ?");
            System.out.println("1.Nibble \t2.Bit \t3.KiloByte \t4.none");
            System.out.print("Enter Option: ");
            ans = sc.nextInt();
            if(ans == 1)
                score+=5;
            else
                score--;

            System.out.println("-------------------------------------------------------------");
            System.out.println("Q4.How many generations are computers currently classified ?");
            System.out.println("1.Six\t2.Four \t3.Five\t4.Two");
            System.out.print("Enter Option: ");
            ans = sc.nextInt();
            if(ans == 3)
                score+=5;
            else
                score--;

            System.out.println("-------------------------------------------------------------");
            System.out.println("Q5.Integrated circuits used in computers were developed using which of the following materials ?");
            System.out.println("1.Silver\t2.Copper\t3.Gold\t4.Silicon");
            System.out.print("Enter Option: ");
            ans = sc.nextInt();
            if(ans == 4)
                score+=5;
            else
                score--;
            System.out.println("-------------------------------------------------------------");
            break; // Remove this if you have more questions
        }

        System.out.println("Exam Finished!!!");
        System.out.println();
        System.out.println("Your Score is " + score);
        if (score > 10) {
            System.out.println("Congratulations you passed!!!");
        } else {
            System.out.println("Better Luck Next Time!!!");
        }
    }

    public static void main(String args[]) {
        OnlineExamPortal obj = new OnlineExamPortal();
        obj.menu();
    }
}
