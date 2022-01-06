import java.util.Scanner;

public class Client {
    public String identifier;
    public String cni;
    public String name;
    public String nationality;
    public int phone;
    public boolean status=true;
    public int result;


    public Client(String identifier, String cni,String name, String nationality,int phone) {
        this.identifier = identifier;
        this.cni = cni;
        this.name = name;
        this.nationality = nationality;
        this.phone = phone;


    }
    public void RegisterClient(){
    }
    public void Test() {
        String choice = "";
         int num_t=0;
        if (status)
        {
            Scanner clavier = new Scanner(System.in);
            System.out.println("Resultat: Negatif ");
            System.out.println("Voulez vous vous faire Vaccine??");
            System.out.println("OUI ou NON ?? :");
            choice = clavier.next();

            switch (choice) {
             case "OUI":
                System.out.println("yes");
                break;
             case "NON":
                System.out.println("Voulez vous vous faire Vaccine??");
                break;
           }

           num_t++;


        }
        else
            System.out.println("You are Positive. quarantine!!!");
        }

    public void Checkstatus(String name){
        String state;
    

        if(name.Test()==true) {
            System.out.println("You are positive!! Quarantine.");
           

        }
        else{
            System.out.println("You are negative. Go ahead and take the vaccination");
            String choice = "";
            System.out.println("Voulez vous vous faire Vaccine??");
            System.out.println("OUI ou NON ?? :");
            Scanner clavier = new Scanner(System.in);
            choice = clavier.next();

          switch (choice) {
            case "OUI":
                System.out.println("yes");
                break;
            case "NON":
                System.out.println("Voulez vous vous faire Vaccine??");
                break;
        }
        }


    }
    public int Num_Client(){

        return Test().num_t;
        
    }
    

    
}