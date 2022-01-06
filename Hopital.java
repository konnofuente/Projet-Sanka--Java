import java.util.Scanner;
public class Hopital {
    public String Name;
    public String City;
    public int Stock_vacc;

    public Hopital(String Name,String City, int Stock_vacc ){
        this.Name=Name;
        this.City=City;
        this.Stock_vacc=Stock_vacc;
    }
    public int Supply_vacc(){
        int num_vac;
        System.out.println("Veillez saisir le nombre de vaccins restant: ");
        Scanner clavier = new Scanner(System.in);
        num_vac=clavier.nextInt();
        if(num_vac<50){
            System.out.println("The stock is finishing!! Add more Vaccines");
        }
            return num_vac;
    }
    public static void main(){
        int comp;
        String a;
        Scanner clavier = new Scanner(System.in);
        System.out.println("Veillez entrer le stock de vaccins: ");
        comp = Integer.parseInt(clavier.next());

    }
}
