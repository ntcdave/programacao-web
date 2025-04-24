public class Relatorio {
        public void relatorioFuncionario(Empregado empregado){
        System.out.println("========================================\n");
        System.out.println("        RELATÓRIO DO FUNCIONÁRIO        \n");
        System.out.println("========================================\n");
        System.out.println(String.format("Nome: %s\n", empregado.getNome()));
        System.out.println(String.format("Idade: %d\n", empregado.getIdade()));
        System.out.println(String.format("Salário:  R$ %.2f\n", empregado.getSalario()));
        System.out.println("========================================\n");
                        
    }

}
