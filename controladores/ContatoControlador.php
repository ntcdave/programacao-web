<?php
    require_once "./conexao/Conexao.php";
    require_once "./DAOs/ContatoDAO.php";
    class ContatoControlador{

        public function salvar($contato){
            try{
                //abrir conexão com o banco
                $conexao = new Conexao();
                $conn = $conexao->getConexao();
                //chamar o ContatoDAO 
                $contatoDAO = new ContatoDAO();
                return $contatoDAO->salvar($contato,$conn);
            }catch(Exception $erro){
                throw $erro;
            }
        }   
        public function buscarTodos(){   
            try{
                //abrir conexão com o banco
                $conexao = new Conexao();
                $conn = $conexao->getConexao();
                //chamar o ContatoDAO 
                $contatoDAO = new ContatoDAO();
                return $contatoDAO->buscarTodos($conn);
            }catch(Exception $erro){
                throw $erro;
            }
        }
        
        public function editarContato($contato){
            try{
                //abrir conexão com o banco
                $conexao = new Conexao();
                $conn = $conexao->getConexao();
                //chamar o ContatoDAO 
                $contatoDAO = new ContatoDAO();
                return $contatoDAO->editarContato($contato,$conn);
            }catch(Exception $erro){
                throw $erro;
            }
        }
        
    }

?>