import java.util.Scanner;

public class Clinic
 
{
    public String id_clinic;
    public String name;
    public String location;
    public String hospital;
    public int qty_vaccine;

    public Clinic(String id_clinic,String name,String location,String hospital,int qty_vaccine)
    {
        this.id_clinic=id_clinic;
        this.name=name;
        this.location=location;
        this.hospital=hospital;
        this.qty_vaccine=qty_vaccine;
    }

    public void hire_nurse()
    {
        String name;
        String speciality;
        int years_of_experience;
        Scanner clavier = new Scanner(System.in);
        System.out.println("Enter your name:");
        name= clavier.next();
        System.out.println("Enter your speciality:");
        speciality= clavier.next();
        System.out.println("Enter your years of experience:");
        years_of_experience=clavier.nextInt();

        if ((speciality.compareTo("virologist")==0 || speciality.compareTo("neutrologist")==0 || speciality.compareTo("lab technician")==0 ) && (years_of_experience >= 5)) 
        {
            System.out.println("You have been successfully employed: Nurse "+ name + " Congradulations.");
        }
        else{
            System.out.println("Sorry you are not qualified. Keep gaining experience!!");
        }
    }

    public void fire_nurse()
    {
            String name;
            String Clinic;
            Scanner clavier = new Scanner(System.in);
            System.out.println("Enter the name of the nurse:");
            name = clavier.next();
            System.out.println("Enter the name of the nurse's clinic:");
            Clinic=clavier.next();

            System.out.println(" Sorry to you Nurse : " + name + " from the " + Clinic + " clinic.YOU HAVE BEEN FIRED!!");


    }
   public void vaccinate()
    {
           String name;
           String nom;
           int vaccinated;
           int num_vac;

           Scanner clavier = new Scanner(System.in);
           name=clavier.next();

            if (name.Client.Test()== true)
                System.out.println("You are positive and can't just be vaccinated.");
            else
            {
                vaccinated=1;
                System.out.println("You have been successfully vaccinated. don't forget to collect your reciet.");
                num_vac ++;
            }
    }

    public int num_vaccinated(){

        return vaccinate().num_vac;
    }

    public int num_tested(){

        return Test().num_t;

    }
    public void increase_vacc(){

        int available_vac;
        int vaccine_pack=150;
        Scanner clavier = new Scanner(System.in);
        available_vac= clavier.nextInt();

        if (available_vac<50){
            available_vac+=vaccine_pack;

        }
        else{
            System.out.println("There are still enough vaccines");
        }


    }


        
}

