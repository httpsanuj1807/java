class Computer{

    public void playMusic(){

        System.out.println("Playing music..");

    }

    public String buyPen(int money){

        if(money > 10) return "Shopping success";
        else return "Not enough money";

    }

}


public class method3 {
    
    public static void main(String args[]){

        Computer obj = new Computer();

        obj.playMusic();
        String result = obj.buyPen(14);

        System.out.println(result);


    }

}
