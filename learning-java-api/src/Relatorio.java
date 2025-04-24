public class Relatorio {
        public void relatorioFuncionario(Funcionario funcionario){
        System.out.println("========================================\n");
        System.out.println("        RELATÓRIO DO FUNCIONÁRIO        \n");
        System.out.println("========================================\n");
        System.out.println(String.format("Nome: %s\n", funcionario.getNome()));
        System.out.println(String.format("Idade: %d\n", funcionario.getIdade()));
        System.out.println(String.format("Salário:  R$ %.2f\n", funcionario.getSalario()));
        System.out.println("========================================\n");
                        
    }
    
        public void relatorioGerente(Gerente gerente){
        System.out.println("========================================\n");
        System.out.println("        RELATÓRIO DO GERENTE        \n");
        System.out.println("========================================\n");
        System.out.println(String.format("Nome: %s\n", gerente.getNome()));
        System.out.println(String.format("Idade: %d\n", gerente.getIdade()));
        System.out.println(String.format("Salário:  R$ %.2f\n", gerente.getBonus()));
        System.out.println("========================================\n");

    }
}
