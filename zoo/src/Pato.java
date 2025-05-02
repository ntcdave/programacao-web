public class Pato extends Animal{
    @Override
    public void nascer() {
        System.out.println("Nascendo do ovo");
    }
    @Override
    public void comer() {
        System.out.println("Comendo como um pato");
    }
    @Override
    public void andar(){
        System.out.println("Andando como um pato");
    }

    @Override
    public void beber() {
        System.out.println("Bebendo como um pato");
    }
}
