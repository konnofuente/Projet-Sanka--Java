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
        if(num_vacc<50){
            System.out.println("The stock is finishing!! Add more Vaccines");
        }

    }
}
