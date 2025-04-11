<?php
    header("Access-Control-Allow-Origin: *");
    header("Access-Control-Allow-Methods: GET, POST, PUT, DELETE, OPTIONS");
    header("Access-Control-Allow-Headers: Content-Type, Authorization");

    require_once "modelos/Contato.php";
    require_once "controladores/ContatoControlador.php";
    
    $acao = $_GET['acao'];

    switch($acao){
        case 'salvarContato':
            $json = file_get_contents("php://input");
          
            $contatoDTO = json_decode($json);
            $nome = $contatoDTO->nome;
            $telefone = $contatoDTO->telefone;
            //criar o objeto Contato
            $contato = new Contato();
            $contato->setNome($nome);
            $contato->setTelefone($telefone);            
            //chamar o controlador
            $contatoControlador = new ContatoControlador();
            try{
                $contato = $contatoControlador->salvar($contato);
                echo json_encode($contato);
            }catch(Exception $erro){
                $erro_json = json_encode($erro);
                echo $erro_json;
            }
            //redirecionar o usuário para outra tela
            break;
        case 'buscarContatos':

            $contatoControlador = new ContatoControlador();
            try{
                $contatos = $contatoControlador->buscarTodos();
                $json_contatos = json_encode($contatos);
                echo $json_contatos;
            }catch(Exception $erro){
                $erro_json = json_encode($erro);
                echo $erro_json;
            }
            break;
    }

?>