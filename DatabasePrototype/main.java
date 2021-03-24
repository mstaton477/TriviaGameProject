package DataBasePrototype;

public class main {
    public static void main(String[] args) {
        PlayerData test = new PlayerData();
        test.setPlayerName("Patrick");
        test.setPlayerScore("5000");
        test.save();

    }
    /*public void display() {

        try {
            Scanner in = new Scanner(new FileReader("TestDatabase.txt"));
            while(in.hasNextLine())
                System.out.println(in.nextLine());

        }
        catch(Exception e){}


    }
    public void insert()
    {
            System.out.println("test");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the player name: ");
            String name = sc.nextLine();
            System.out.println("Enter score: ");
            String score = sc.nextLine();
            System.out.println("Enter category: ");
            String category = sc.nextLine();
            System.out.println("Enter date: ");
            String date = sc.nextLine();



            try
            {
                File f = new File("TestDatabase.txt");
                PrintWriter pw = new PrintWriter(new FileOutputStream(f, true));
                pw.append("\n "+ name + "||"+ score + "||"+ category + "||"+ date);
                pw.close();
            }
            catch(Exception e){}
        }*/
    }

