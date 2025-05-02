public class Galinha extends Animal{
    @Override
    public void nascer() {
        System.out.println("Nascendo do ovo");
    }
    @Override
    public void comer() {
        System.out.println("Comendo como uma galinha");
    }
        @Override
    public void andar(){
        System.out.println("Andando como uma galinha");
    }

    @Override
    public void beber() {
        System.out.println("Bebendo como uma galinha");
    }
}
