<?php

    class Conexao{

        private $conexao = null; 

        function __construct(){
            try{
                $this->conexao = new PDO("mysql:host=localhost;dbname=agenda", "root", "");
                // set the PDO error mode to exception
                $this->conexao->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            }catch(Exception $erro){
                throw $erro;
            }
        }

        public function getConexao(){
            return $this->conexao;
        }

        public function fechar(){
            $this->conexao=null;
        }

    }
?>