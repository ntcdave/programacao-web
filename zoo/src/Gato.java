public class Gato extends Animal{
    @Override
    public void nascer() {
        System.out.println("Nascendo como um gato");
    }
    @Override
    public void comer() {
        System.out.println("Comendo como um gato");
    }
    @Override
    public void andar(){
        System.out.println("Andando como um gato");
    }

    @Override
    public void beber() {
        System.out.println("Bebendo como um gato");
    }
}